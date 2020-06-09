package bd.edu.seu.messmanagementsystemfrontend.ui.admin;import bd.edu.seu.messmanagementsystemfrontend.exceptions.ResourceNotFoundException;import bd.edu.seu.messmanagementsystemfrontend.model.UserWithRole;import bd.edu.seu.messmanagementsystemfrontend.service.MemberAndManagerListService;import bd.edu.seu.messmanagementsystemfrontend.ui.Footer;import com.vaadin.flow.component.button.Button;import com.vaadin.flow.component.button.ButtonVariant;import com.vaadin.flow.component.formlayout.FormLayout;import com.vaadin.flow.component.grid.Grid;import com.vaadin.flow.component.html.Div;import com.vaadin.flow.component.icon.VaadinIcon;import com.vaadin.flow.component.notification.Notification;import com.vaadin.flow.component.orderedlayout.VerticalLayout;import com.vaadin.flow.component.select.Select;import com.vaadin.flow.component.textfield.TextField;import com.vaadin.flow.router.Route;import javax.servlet.http.HttpSession;import java.util.List;@Route("memberAndManager")public class MemberAndManagerList extends VerticalLayout {    private MemberAndManagerListService memberAndManagerListService;    public MemberAndManagerList(HttpSession httpSession,MemberAndManagerListService memberAndManagerListService) {        super();        this.memberAndManagerListService= memberAndManagerListService;        AdminHeadeer adminHeadeer = new AdminHeadeer(httpSession);        adminHeadeer.addAttachListener(attachEvent -> {            String userRole =(String) httpSession.getAttribute("user");            if(userRole==null) userRole="unknown";            Notification.show(userRole);            if(!userRole.equals("Admin")){                httpSession.removeAttribute("user");                adminHeadeer.getUI().ifPresent(ui -> ui.navigate("login"));            }        });        Div body = new Div();        TextField usernameField = new TextField("Username","username");        Select<String> role = new Select<>("Member","Manager","Admin");        role.setLabel("Role");        role.setPlaceholder("User Role");        Button update = new Button("Update", VaadinIcon.EXCHANGE.create());        update.addThemeVariants(ButtonVariant.LUMO_PRIMARY);        update.setSizeFull();        FormLayout formLayout = new FormLayout(usernameField,role);        Grid<UserWithRole> userWithRoleGrid = getGrid();        body.add(formLayout,update,userWithRoleGrid);        body.setSizeFull();        Footer footer = new Footer();        add(adminHeadeer,body,footer);        userWithRoleGrid.addItemClickListener(item->{            UserWithRole userWithRole = item.getItem();            usernameField.setValue(userWithRole.getUsername());            role.setValue(userWithRole.getRole().toString());        });        update.addClickListener(event->{            if(!usernameField.isEmpty() && !role.isEmpty()){                Notification.show(memberAndManagerListService.updateUserRole(usernameField.getValue(), role.getValue()));                try {                    userWithRoleGrid.setItems(memberAndManagerListService.getMemberAndMangers());                } catch (ResourceNotFoundException e) {                    Notification.show("empty list");                }            }else{                Notification.show("empty field is not allowed");            }        });    }    public Grid<UserWithRole> getGrid(){        Grid<UserWithRole> userWithRoleGrid = new Grid<>(UserWithRole.class);        List<UserWithRole> userWithRolesList;        try {            userWithRolesList = memberAndManagerListService.getMemberAndMangers();            userWithRoleGrid.setItems(userWithRolesList);        } catch (ResourceNotFoundException e) {            Notification.show("list is empty");        }        return userWithRoleGrid;    }}
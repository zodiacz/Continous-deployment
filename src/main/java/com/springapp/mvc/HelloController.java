package com.springapp.mvc;


import com.springapp.mvc.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@SessionAttributes({"userName","role"})
public class HelloController {
    //private BeanValidator beanValidator = new BeanValidator(new AnnotationBeanValidationConfigurationLoader());
    @ModelAttribute("userName")
    String getUserName(){
        return "";
    }

    @ModelAttribute("role")
    String getRole(){return "";}



	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model,@ModelAttribute("userName") String userName) {
//		model.addAttribute("message", "Hello world!");
//		return "hello";
        if (userName.equals(""))

            model.addAttribute("loginEntity",new Login());
            return "login";
        }
        else{
            model.addAttribute("message", "Hello world!");
            return "hello";
        }

	}



    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(ModelMap model,@ModelAttribute("userName") String userName) {
//		model.addAttribute("message", "Hello world!");
//		return "hello";

            model.addAttribute("userName","");
            model.addAttribute("loginEntity",new Login());
            return "login";


    }
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(ModelMap model,@ModelAttribute("userName") String userName) {
//        model.addAttribute("role","");
        model.addAttribute("userName","");
        model.remove("role");

        return "redirect:/login";


    }


    @RequestMapping(value = "validate",method = RequestMethod.POST)
    public String validate(@ModelAttribute("loginEntity") Login login, BindingResult bindingResult, ModelMap model,@ModelAttribute("userName") String userName){
//        beanValidator.validate(login, bindingResult);
        if (bindingResult.hasErrors()){
            return "login";
        }
        String name;

        if (login.getUserName() == null || login.getUserName().equals("")){
            name = "Damn, Why don't you input the name";
            model.addAttribute("errorMessage",name);
            return "login";
        }   else{
            name = login.getUserName();
        }
        String role = getRole(login.getUserName(),login.getPassword());
        name = new StringBuilder(name).reverse().toString();
        if (role != null) {
            model.addAttribute("userName", name);
            model.addAttribute("role",role);
            return "result";
        }
        else{
            String errorMessage = "Wrong user name or password";
            model.addAttribute("userName", name);
            model.addAttribute("errorMessage",errorMessage);
            return "login";
        }
    }

    String[][] data = {{"Admin","admin","Administrator"},
                            {"User1","user","User"},
                            {"User2","check","Owner"}};
    private String getRole(String username,String password){
        try {
            for (int i = 0; i < data.length;i++){
                if (username.equals(data[i][0]) && password.equals(data[i][1])){
                    return data[i][2];
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    @RequestMapping(value="checkTriangle",method = RequestMethod.POST)
    public String checkTriangle(@RequestParam("a")String sa, @RequestParam("b")String sb,@RequestParam("c")String sc
            ,@ModelAttribute("userName")String userName
            ,@ModelAttribute("role")String role, ModelMap model){
        int a = 0,b=0,c=0;
        model.addAttribute("a",sa);
        model.addAttribute("b",sb);
        model.addAttribute("c",sc);
        model.addAttribute("userName",userName);
        model.addAttribute("role",role);
        if (sa == null || sb == null || sc == null){
            model.addAttribute("inputError","true");
            return "result";
        } else{
            try{
                a = Integer.parseInt(sa);
                b = Integer.parseInt(sb);
                c = Integer.parseInt(sc);

            }catch( NumberFormatException e){
                model.addAttribute("inputError","true");
                return "result";
            }
        }


        String type;
        if (isTriangle(a,b,c)){
            if (isEquilateral(a,b,c)){
                type = "equilateral";
            }else if (isIsoscelenes(a,b,c)){
                type = "isoscelene";
            }else{
                type = "scalene";
            }
        }else{
            type = "none";
        }
        model.addAttribute("triType",type);
        return "result";

    }

    public boolean isTriangle(int a,int b,int c){
        if (a > b+c || b > a+c || c > a+b ){
            return false;
        }else
            return true;
    }
    public boolean isEquilateral(int a,int b,int c){
        if (a ==b && b == c && a == c){
            return true;
        }
        else
            return false;
    }
    public boolean isIsoscelenes(int a,int b,int c){
        int count = 0;
        if (a==b){
            count++;
        }
        if (a==c){
            count++;
        }
        if (b==c){
            count++;
        }
        if (count == 1){
            return true;
        }
        else
            return false;
    }

}
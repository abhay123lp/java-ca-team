using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ShoppingCart.Account
{
    public partial class Login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            RegisterHyperLink.NavigateUrl = "Register.aspx?ReturnUrl=" + HttpUtility.UrlEncode(Request.QueryString["ReturnUrl"]);
        }

        protected void login_loggedIn(object sender, EventArgs e)
        {
            //Login loginControl = (Login)LoginUser.Controls[0].Controls[1].FindControl("Login1");
              string UserName = LoginUser.UserName;
                String pwd = LoginUser.Password;
                Session["user"] = (new RegisteredUser_Action().GetDetails(UserName, pwd));
                //Response.Redirect("~/Account/test.aspx");

            

            
           
            
        }

    }
}

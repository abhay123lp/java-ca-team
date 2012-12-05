using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ShoppingCart.Account
{
    public partial class test : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            Response.Write(((RegisteredUser)Session["user"]).Name);
            Response.Write(((RegisteredUser)Session["user"]).User_ID);
        }
    }
}
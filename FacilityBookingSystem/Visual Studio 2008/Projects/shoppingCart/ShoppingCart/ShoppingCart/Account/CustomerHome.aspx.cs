using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ShoppingCart.Account
{
    public partial class CustomerHome : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            Menu menu = (Menu)Master.FindControl("CategoriesMenu");      
          
           MenuItem m1=new MenuItem();
            m1.Text="My Profile";
             MenuItem m2=new MenuItem();
            m2.Text="My Orders";
             MenuItem m3=new MenuItem();
            m3.Text="My GiftVochers";
           
           
         menu.Items.Add(m1);
        menu.Items.Add(m2);
       menu.Items.Add(m3);
            // return MenuList;
        }


        }
    }

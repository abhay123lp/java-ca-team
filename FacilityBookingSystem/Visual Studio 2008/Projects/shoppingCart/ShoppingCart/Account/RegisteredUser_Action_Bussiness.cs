using System;
using System.Collections.Generic;
using System.Collections;
using System.Linq;
using System.Web;

namespace ShoppingCart.Account
{
    public class RegisteredUser_Action
    {
      

        public bool ChangePassword(string New_pwd)
        {
            return true;
        }

        public bool UpdateProfile(List<string> changed_details)
        {
            return true;
        }

        public ArrayList GetOrderDetails()
        {
            return (new ArrayList());
        }

        public RegisteredUser GetDetails(String name, String pwd)
        {
            
           ArrayList details=RegisteredUserADO.GetUserDetails(name,pwd);
          RegisteredUser user = new RegisteredUser((String)details[0],(string)details[1], (string)details[2],
               (string)details[2], name, pwd);
           return user;
           

        }

        public string GetItems(string OrderId)
        {
            String Items="";
            ArrayList ItemList= RegisteredUserADO.GetItems(OrderId);
            for (int i = 0; i < ItemList.Count; i++)
            {
                Items=Items+ItemList[i];
            }

            return Items;
        }



    }
}
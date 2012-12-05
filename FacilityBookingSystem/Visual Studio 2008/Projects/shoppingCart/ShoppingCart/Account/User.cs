using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ShoppingCart.Account
{
    public class User
    {
       protected string name;

        public string Name
        {
            get
            {
                return name;
            }
        }

        public User(string name)
        {
            this.name = name;
        }
    }
}
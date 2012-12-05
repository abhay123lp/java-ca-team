using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ShoppingCart.Account
{
    public class RegisteredUser:User
    {
        //attributes
        String User_id;
        string address;
        string phone_number;
        string user_name;
        string password;
        String email;
      
        //properties

        public string User_ID
        {
            get
            {
                return User_id;
            }
        }

        public string Address
        {
            get
            {
                return address;
            }

            set
            {
                address = value;
            }
        }

        public string PhoneNumber
        {
            get
            {
                return phone_number;
            }
            set
            {
                phone_number = value;
            }
        }

        public string Email
        {
            get
            {
                return email;
            }
            set
            {
                phone_number = email;
            }
        }

        
        //constructors

        public RegisteredUser(String id,string name, string addr, string ph, string email,string u_name, string pwd):base(name)
        {
            User_id = id;
         
            address = addr;
            phone_number = ph;
            this.user_name = u_name;
            password = pwd;
            this.email = email;
            
        }

          public RegisteredUser(string id,string name, string addr,string email,string u_name, string pwd)
              :this(id,name,addr,"",email,u_name,pwd)
        {

          }




         







    }
}
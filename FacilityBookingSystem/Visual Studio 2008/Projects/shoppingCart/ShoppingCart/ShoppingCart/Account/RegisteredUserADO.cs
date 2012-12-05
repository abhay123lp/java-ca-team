using System;
using System.Collections.Generic;
using System.Collections;
using System.Linq;
using System.Web;
using System.Data;
using System.Data.SqlClient;

namespace ShoppingCart.Account
{
    public class RegisteredUserADO
    {
        static SqlConnection con;
        private RegisteredUserADO()
        {
        }

        

        public static ArrayList GetUserDetails(string name, string pwd)
        {
            ArrayList user_details = new ArrayList();
          
               string s = "data source=(local);initial catalog=ShoppingCart;integrated security=SSPI";
               con = new SqlConnection(s);
               con.Open();
               SqlParameter pMC = new SqlParameter("@MC", SqlDbType.NVarChar, 30);
               SqlParameter pCID = new SqlParameter("@CID", SqlDbType.NVarChar, 30);

               SqlCommand cm = new SqlCommand(
               "select CustomerID,CustomerName,CustomerEmail,CustomerAddress from CustomerProfile where UserName=@MC and UserPwd=@CID",con);
               cm.Parameters.Add(pMC);
               cm.Parameters.Add(pCID);
               pMC.Value = name;
               pCID.Value = pwd;

            SqlDataReader rd = cm.ExecuteReader();
               while (rd.Read())
               {
                   user_details.Add(rd["CustomerID"]);
                   user_details.Add(rd["CustomerName"]);
                   user_details.Add(rd["CustomerAddress"]);
                   user_details.Add(rd["CustomerEmail"]);
               }


              
           
                
           
          
            
                       con.Close();

                       return user_details;
               
           }
        }
    }

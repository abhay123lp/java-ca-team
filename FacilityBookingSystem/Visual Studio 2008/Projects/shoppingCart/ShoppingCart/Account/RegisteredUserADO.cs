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

        public static void OpenConnection()
        {
            string s = "data source=(localhost);initial catalog=ShoppingCart;integrated security=SSPI";
               con = new SqlConnection(s);
               con.Open();
        }

        public static ArrayList GetUserDetails(string name, string pwd)
        {
            ArrayList user_details = new ArrayList();
          
               OpenConnection();
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

        public Static ArrayList GetItems(String OrderId)
        {
             OpenConnection();
             SqlParameter Oid = new SqlParameter("@id", SqlDbType.NVarChar, 30);
            SqlCommand cm = new SqlCommand(
               "select  from CustomerProfile where UserName=@MC and UserPwd=@CID",con);
               cm.Parameters.Add(pMC);
               cm.Parameters.Add(pCID);
               pMC.Value = name;
               pCID.Value = pwd;
             con.Close();
           
        }
        }
    }

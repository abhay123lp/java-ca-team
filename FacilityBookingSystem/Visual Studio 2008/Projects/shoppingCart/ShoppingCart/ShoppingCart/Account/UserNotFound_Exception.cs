using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ShoppingCart.Account
{
    public class UserNotFound_Exception:ApplicationException
    {
        public UserNotFound_Exception() : base() { }
        public UserNotFound_Exception(string Message)
            : base(Message)
        {
        }
        public UserNotFound_Exception(string Message, Exception innex)
            : base(Message, innex)
        {
        }
    }
}
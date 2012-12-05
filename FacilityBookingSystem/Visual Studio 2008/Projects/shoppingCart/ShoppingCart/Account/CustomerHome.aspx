<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="CustomerHome.aspx.cs" Inherits="ShoppingCart.Account.CustomerHome" %>
<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
         


  
        <table style="width:100%;">
            <tr>
                <td>
                    <p>
                        &nbsp;</p>
                    <p>
                        My profile</p>
                </td>
                <td>
                    &nbsp;</td>
                <td>
                    &nbsp;</td>
            </tr>
            <tr>
                <td>
                    <p>
                        &nbsp;</p>
                    <p>
                        &nbsp;</p>
                </td>
                <td>
                    UserName:</td>
                <td>
&nbsp;&nbsp;&nbsp;
                    <asp:Literal ID="UserName" runat="server"></asp:Literal>
                </td>
            </tr>
            <tr>
                <td>
                    &nbsp;</td>
                <td>
                    &nbsp;</td>
                <td>
                    <asp:HyperLink ID="Link_ChangePassword" runat="server">Change password</asp:HyperLink>
                </td>
            </tr>
            <tr>
                <td>
                    Address<br />
                </td>
                <td>
                    &nbsp;</td>
                <td>
                </td>
            </tr>
            <tr>
                <td>
                    <br />
                </td>
                <td>
                    <asp:TextBox ID="Address" runat="server" TextMode="MultiLine"></asp:TextBox>
                </td>
                <td>
                </td>
            </tr>
            <tr>
                <td>
                    Address<br />
                </td>
                <td>
                    &nbsp;</td>
                <td>
                </td>
            </tr>
            
        </table>
  
    </asp:Content>

<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="MyOrder.aspx.cs" Inherits="ShoppingCart.Account.MyOrder" %>
<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
<div>
<h2> My orders</h2>
</div>
<div>
    <%--<asp:Table ID="Table1" runat="server" Height="190px" Width="413px">
    <asp:TableHeaderRow >
    <asp:TableHeaderCell Text="OrderID"></asp:TableHeaderCell>
    Items
    Amount
    Transaction Date
    Status--%>
    </asp:TableHeaderRow>
    </<asp:GridView runat="server" DataSourceID="SqlDataSource2" 
        AutoGenerateColumns="False" DataKeyNames="CartTransactionID">
        <Columns>
            <asp:BoundField DataField="CartTransactionID" HeaderText="CartTransactionID" 
                ReadOnly="True" SortExpression="CartTransactionID" />
            <asp:BoundField DataField="TransactionDate" HeaderText="TransactionDate" 
                SortExpression="TransactionDate" />
            <asp:BoundField DataField="TransactionStatus" HeaderText="TransactionStatus" 
                SortExpression="TransactionStatus" />
            <asp:TemplateField HeaderText="Items">
                <EditItemTemplate>
                    <asp:Literal ID="Literal1" runat="server"></asp:Literal>
                </EditItemTemplate>
            </asp:TemplateField>
        </Columns>
        </asp:GridView>
   
    <asp:Image ID="Image1" runat="server" />
    <asp:SqlDataSource ID="SqlDataSource2" runat="server" 
        ConnectionString="<%$ ConnectionStrings:ShoppingCartConnectionString %>" 
        SelectCommand="SELECT [CartTransactionID], [TransactionDate], [TransactionStatus] FROM [CartTransaction] WHERE ([CustomerID] = @CustomerID)">
        <SelectParameters>
            <asp:SessionParameter DefaultValue="User_ID" Name="CustomerID" 
                SessionField="user" Type="String" />
        </SelectParameters>
    </asp:SqlDataSource>
   
</div>
</asp:Content>

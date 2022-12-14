package beans;

import dbcon.JDBCConn;
//import java.io.PrintStream;
import java.sql.*;

public class ContractBean
{

    public ContractBean()
    {
    }

    public int getContractno()
    {
        return contractno;
    }

    public void setContractno(int contractno)
    {
        this.contractno = contractno;
    }

    public int getCustid()
    {
        return custid;
    }

    public void setCustid(int custid)
    {
        this.custid = custid;
    }

    public String getDeliverydate()
    {
        return deliverydate;
    }

    public void setDeliverydate(String deliverydate)
    {
        this.deliverydate = deliverydate;
    }

    public String getDeliveryday()
    {
        return deliveryday;
    }

    public void setDeliveryday(String deliveryday)
    {
        this.deliveryday = deliveryday;
    }

    public int getHaulid()
    {
        return haulid;
    }

    public void setHaulid(int haulid)
    {
        this.haulid = haulid;
    }

    public int getProdid()
    {
        return prodid;
    }

    public void setProdid(int prodid)
    {
        this.prodid = prodid;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public int insert()
        throws Exception
    {
        Connection con = JDBCConn.getConnection();
        PreparedStatement pstmt = con.prepareStatement("insert into contract values(?,?,?,?,?,?,?)");
        pstmt.setInt(1, contractno);
        pstmt.setInt(2, custid);
        pstmt.setInt(3, prodid);
        pstmt.setInt(4, haulid);
        pstmt.setString(5, deliverydate);
        pstmt.setString(6, deliveryday);
        pstmt.setInt(7, quantity);
        try
        {
        int i = pstmt.executeUpdate();
        System.out.println("data inserted");
        pstmt.close();
        con.close();
        return i;
        }
        catch(Exception e){
        	return 0;
        }
    }

    public void select()
        throws Exception
    {
        Connection con = JDBCConn.getConnection();
        System.out.println("In select of Case");
        PreparedStatement pstmt = con.prepareStatement("select * from contract where contractno=?");
        System.out.println("after pstmt");
        pstmt.setInt(1, contractno);
        ResultSet rs = pstmt.executeQuery();
        System.out.println("entered into case java");
        for(; rs.next(); System.out.println("....data retrieved...."))
        {
            contractno = rs.getInt(1);
            custid = rs.getInt(2);
            prodid = rs.getInt(3);
            haulid = rs.getInt(4);
            deliverydate = rs.getString(5);
            deliveryday = rs.getString(6);
            quantity = rs.getInt(7);
            System.out.println(contractno);
            System.out.println(deliverydate);
        }

    }

    public int delete(int articleid)
        throws Exception
    {
        Connection con = JDBCConn.getConnection();
        String query = "DELETE  FROM contract WHERE contractno=" + contractno;
        Statement stmt = con.createStatement();
        int i = stmt.executeUpdate(query);
        return i;
    }

    private int contractno;
    private int custid;
    private int haulid;
    private int prodid;
    private int quantity;
    private String deliverydate;
    private String deliveryday;
}

package com.definesys.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2019/1/5 下午2:56
 * @history: 1.2019/1/5 created by jianfeng.zheng
 */
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "   <SOAP-ENV:Header/>\n" +
                "   <SOAP-ENV:Body>\n" +
                "      <ns2:EmployeeDetailResponse xmlns:ns2=\"http://www.definesys.com/xml/employee\">\n" +
                "         <ns2:Employee>\n" +
                "            <ns2:name>jianfeng</ns2:name>\n" +
                "            <ns2:email>jianfeng.zheng@definesys.com</ns2:email>\n" +
                "         </ns2:Employee>\n" +
                "      </ns2:EmployeeDetailResponse>\n" +
                "   </SOAP-ENV:Body>\n" +
                "</SOAP-ENV:Envelope>";
        resp.getOutputStream().write(response.getBytes());
    }
}

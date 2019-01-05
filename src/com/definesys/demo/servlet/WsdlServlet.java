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
 * @since: 2019/1/5 下午1:45
 * @history: 1.2019/1/5 created by jianfeng.zheng
 */
public class WsdlServlet extends HttpServlet {
    public static final String WSDL_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><wsdl:definitions xmlns:wsdl=\"http://schemas.xmlsoap.org/wsdl/\" xmlns:sch=\"http://www.definesys.com/xml/employee\" xmlns:soap=\"http://schemas.xmlsoap.org/wsdl/soap/\" xmlns:tns=\"http://www.definesys.com/xml/employee\" targetNamespace=\"http://www.definesys.com/xml/employee\">\n" +
            "  <wsdl:types>\n" +
            "    <xs:schema xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" elementFormDefault=\"qualified\" targetNamespace=\"http://www.definesys.com/xml/employee\">\n" +
            "\n" +
            "    <xs:element name=\"EmployeeDetailRequest\">\n" +
            "        <xs:complexType>\n" +
            "            <xs:sequence>\n" +
            "                <xs:element name=\"name\" type=\"xs:string\"/>\n" +
            "            </xs:sequence>\n" +
            "        </xs:complexType>\n" +
            "    </xs:element>\n" +
            "\n" +
            "    <xs:element name=\"EmployeeDetailResponse\">\n" +
            "        <xs:complexType>\n" +
            "            <xs:sequence>\n" +
            "                <xs:element name=\"Employee\" type=\"tns:Employee\"/>\n" +
            "            </xs:sequence>\n" +
            "        </xs:complexType>\n" +
            "    </xs:element>\n" +
            "\n" +
            "    <xs:complexType name=\"Employee\">\n" +
            "        <xs:sequence>\n" +
            "            <xs:element name=\"name\" type=\"xs:string\"/>\n" +
            "            <xs:element name=\"email\" type=\"xs:string\"/>\n" +
            "        </xs:sequence>\n" +
            "    </xs:complexType>\n" +
            "\n" +
            "</xs:schema>\n" +
            "  </wsdl:types>\n" +
            "  <wsdl:message name=\"EmployeeDetailRequest\">\n" +
            "    <wsdl:part element=\"tns:EmployeeDetailRequest\" name=\"EmployeeDetailRequest\">\n" +
            "    </wsdl:part>\n" +
            "  </wsdl:message>\n" +
            "  <wsdl:message name=\"EmployeeDetailResponse\">\n" +
            "    <wsdl:part element=\"tns:EmployeeDetailResponse\" name=\"EmployeeDetailResponse\">\n" +
            "    </wsdl:part>\n" +
            "  </wsdl:message>\n" +
            "  <wsdl:portType name=\"Employee\">\n" +
            "    <wsdl:operation name=\"EmployeeDetail\">\n" +
            "      <wsdl:input message=\"tns:EmployeeDetailRequest\" name=\"EmployeeDetailRequest\">\n" +
            "    </wsdl:input>\n" +
            "      <wsdl:output message=\"tns:EmployeeDetailResponse\" name=\"EmployeeDetailResponse\">\n" +
            "    </wsdl:output>\n" +
            "    </wsdl:operation>\n" +
            "  </wsdl:portType>\n" +
            "  <wsdl:binding name=\"EmployeeSoap11\" type=\"tns:Employee\">\n" +
            "    <soap:binding style=\"document\" transport=\"http://schemas.xmlsoap.org/soap/http\"/>\n" +
            "    <wsdl:operation name=\"EmployeeDetail\">\n" +
            "      <soap:operation soapAction=\"\"/>\n" +
            "      <wsdl:input name=\"EmployeeDetailRequest\">\n" +
            "        <soap:body use=\"literal\"/>\n" +
            "      </wsdl:input>\n" +
            "      <wsdl:output name=\"EmployeeDetailResponse\">\n" +
            "        <soap:body use=\"literal\"/>\n" +
            "      </wsdl:output>\n" +
            "    </wsdl:operation>\n" +
            "  </wsdl:binding>\n" +
            "  <wsdl:service name=\"EmployeeService\">\n" +
            "    <wsdl:port binding=\"tns:EmployeeSoap11\" name=\"EmployeeSoap11\">\n" +
            "      <soap:address location=\"http://localhost:8081/ws-servlet/ws/employee-detail\"/>\n" +
            "    </wsdl:port>\n" +
            "  </wsdl:service>\n" +
            "</wsdl:definitions>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/xml");
        resp.getOutputStream().write(WSDL_XML.getBytes());
    }
}

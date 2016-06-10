<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getAttribute("name").toString();
		String[] fields = (String[]) request.getAttribute("fieldsName");
	%>
	HI <%=name %>
	<FORM ACTION=dynamicForm.jsp METHOD=POST>
		<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0>
			<%
				for (int j = 0; j <fields.length; j++) {
			%>
			<TR>
				<TD><%=fields[j]%>:</TD>
				<TD><INPUT TYPE="TEXT" NAME="<%=fields[j]%>"></TD>
			</TR>
			<%
				}
			%>
			
		</TABLE>
		<INPUT TYPE=SUBMIT VALUE=Submit>
	</FORM>
</body>
</html>
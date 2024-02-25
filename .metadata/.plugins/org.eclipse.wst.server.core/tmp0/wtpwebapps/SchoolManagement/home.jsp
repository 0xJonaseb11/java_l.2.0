<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <%@ page import="java.util.List"  %>
    <%@ page import="Users.UserModel" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  @import url('https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap');
*
{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Quicksand', sans-serif;
}
body 
{
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background: #000;
  color:#fff;
}
section 
{
  position: absolute;
  width: 100vw;
  height: 100vh;
  display: flex;
  flex-direction:column;
}
.navigation{
width:100%;
justify-content:space-between;
display:flex;
align-items:center;
padding:20px 30px;
background-color: #333;
color:white;
}
.navigation a{
color:white;
text-decoration:none;
}

.button{
padding:15px 30px;
background-color:#0f0;
text-decoration:none;
color:black;
border-radius:3px;
font-weight:600;
}
.flexBetween{
width:100%;
display:flex;
justify-content:space-between;
padding:20px 10px;
}


</style>
</head>
<body>
<section>
<nav class="navigation">
<a href="/">Home</a>
<a href="/Logout">Logout</a>
</nav>
<div class="flexBetween">
<h1>User</h1>
<a href="/SchoolManagement/create_student.jsp" class="button">Register student</a>
<a href="/SchoolManagement/create_user.jsp" class="button">Create user</a>
</div>

    <table border="1" width="100%">
        <tr>
            <th>Id</th>
            <th>Name</th>
           
            <th>Email</th>
            <th>Role</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        
         
       
           <c:forEach var="user" items="${list}">
           
           <tr>
                <td></td>
                   <td><c:out value="${user.username}"/></td>
                 <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.role}"/></td>
                <td><a href="SchoolManagement/edit"/>Edit</td>
                <td><a href="SchoolManagement/delete"/>Delete</td>
               
            </tr>
            
           </c:forEach> 

    </table>
    <H1>sTUDENTS</H1>
     <table border="1" width="100%">
        <tr>
            <th>Id</th>
            <th>name</th>
           
            <th>Email</th>
            <th>school</th>
            <th>Mobile</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        
         
       
           <c:forEach var="student" items="${students}">
           
           <tr>
                <td></td>
                   <td><c:out value="${student.name}"/></td>
                 <td><c:out value="${student.email}"/></td>
                <td><c:out value="${student.school}"/></td>
                  <td><c:out value="${student.phoneNumber}"/></td>   
                    <td><c:out value="${student.age}"/></td>   
                  <td><c:out value="${student.school}"/></td>             
                <td><a href="SchoolManagement/edit"/>Edit</td>
                <td><a href="SchoolManagement/delete"/>Delete</td>
               
            </tr>
            
           </c:forEach> 

    </table>
</section>

</body>
</html>
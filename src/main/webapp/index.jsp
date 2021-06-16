<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP Ajax </title>

    <script>
        var xMLHttpRequest = new XMLHttpRequest();
        function findTutorials(){
            xMLHttpRequest.open("Get", "AjaxServlet?topicName="+document.getElementById('topicName').value, true);
            xMLHttpRequest.onreadystatechange = processTutorials;
            xMLHttpRequest.send(null);
        }
        function processTutorials(){
            if(xMLHttpRequest.readyState === 4 && xMLHttpRequest.status === 200){
                alert(xMLHttpRequest.responseText);
                var JSONTopicObject = eval('('+xMLHttpRequest.responseText+')');
                var table = document.getElementById("tutorialsTable");
                table.innerHTML = "";
                var headrow = table.insertRow(0);
                var headcell = headrow.insertCell(0);
                headcell.style.backgroundColor = "lightblue";
                headcell.innerHTML = JSONTopicObject.topic.name;
                var tutorials = JSONTopicObject.topic.tutorial;
                var i = 0;
                while (i < tutorials.length) {
                    row = table.insertRow(i+1);
                    cell = row.insertCell(0);
                    cell.innerHTML = tutorials[i++].name;
                }
            }
        }
    </script>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br>
<br>
<input type="text" id="topicName" size="20"/>
<button type="submit" onclick="findTutorials()">Find Tutorials</button>  <br>
<br><table id="tutorialsTable" style="border: 1px solid black"></table>
</body>
</html>
<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
	<form action="newAccountForm", method="post", name="registerForm">
		<h3>User Information</h3>

		<table>
			<tr>
				<td>User ID:</td>
				<td><input type="text" name="username" onblur="usernameIsExist()"/></td>
				<td><div id="usernameMsg"></div></td>
			</tr>
			<tr>
				<td>New password:</td>
				<td><input type="password" name="password" onblur="passwordIsValid()"/></td>
				<td><div id="newPasswordMsg"></div></td>
			</tr>
			<tr>
				<td>Repeat password:</td>
				<td><input type="password" name="repeatedPassword" onblur="repeatedPasswordIsValid()"/></td>
				<td><div id="repeatPasswordMsg"></div></td>
			</tr>

			<script language="javascript">
				var xmlHttpRequest;
				var isPreparedForRegister = true;
				function createXMLHttpRequest(){
					if(window.XMLHttpRequest){
						xmlHttpRequest = new XMLHttpRequest();
					}else if(window.ActiveXObject){
						xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
					}else{
						xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
					}
				}

				function usernameIsExist() {
					var username = document.registerForm.username.value;
					if(username == ""){
						var div = document.getElementById("usernameMsg");
						isPreparedForRegister = false;
						div.innerHTML = "<font color='red'>Username Can't Be Emtpy</font>";
					}else{
						isPreparedForRegister = true;
						sendRequeset("usernameIsExist?username="+username);
					}

				}

				function passwordIsValid(){
					var password = document.registerForm.password.value;
					var div = document.getElementById("newPasswordMsg");
					if(password == ""){
						isPreparedForRegister = false;
						div.innerHTML = "<font color='red'>Password Can't Be Emtpy</font>";
					}else{
						isPreparedForRegister = true;
						div.innerHTML = "<font color='green'>Password Is Available</font>";
					}
				}


				function repeatedPasswordIsValid(){
					var password = document.registerForm.password.value;
					var repeatedPassword = document.registerForm.repeatedPassword.value;
					var div = document.getElementById("repeatPasswordMsg");
					if(password != repeatedPassword){
						isPreparedForRegister = false;
						div.innerHTML = "<font color='red'>Password Doesn't Match Repeated Password</font>";
					}else{
						isPreparedForRegister = true;
						div.innerHTML = "<font color='green'>Password Matches Repeated Password</font>";
					}
				}

				function sendRequeset(url){
					createXMLHttpRequest();
					xmlHttpRequest.open("GET", url, true);
					xmlHttpRequest.onreadystatechange = processResponse;
					xmlHttpRequest.send(null);
				}

				function processResponse(){
					if(xmlHttpRequest.readyState == 4){
						if(xmlHttpRequest.status == 200){
							var responseInfo = xmlHttpRequest.responseXML.getElementsByTagName("msg")[0].firstChild.data;
							var div = document.getElementById("usernameMsg");

							if(responseInfo == "Exist"){
								isPreparedForRegister = false;
								div.innerHTML = "<font color='red'>Username Exist</font>";
							}else{
								isPreparedForRegister = true;
								div.innerHTML = "<font color='green'>Username Available</font>";
							}
						}
					}
				}

			</script>

		</table>

		<%@ include file="IncludeAccountFields.jsp"%>
		<input type="submit" name="registerAccount" value="Register Account Information" onclick="return preparedForRegister()"/>
		<script language="javascript">
			function preparedForRegister(){
				return isPreparedForRegister;
			}
		</script>
	</form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>
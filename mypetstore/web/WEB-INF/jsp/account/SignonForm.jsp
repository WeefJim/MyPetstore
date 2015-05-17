<%@ include file="../common/IncludeTop.jsp"%>

<c:if test="${requestScope.loginMsg != null}">
	<div id="Content"><ul class="messages"><font color="red"><li>${requestScope.loginMsg}</li></font></ul>
</c:if>


<div id="Catalog">

	<form action="accountLogin" method="post">
		<p>Please enter your username and password.</p>
		<p><input name="username" type="text" value="j2ee"/><br/>
		<input name="password" type="password" value="j2ee"></p>
		<input class="Button" name="signon" type="submit" value="Login"/>
	</form>
	Need a user name and password?<a href="viewNewAccount">Register Now!</a>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>


<h3>Account Information</h3>

<table>
	<tr>
		<td>First name:</td>
		<td><input type="text" name="firstName" value="${sessionScope.loginAccount.firstName}"/></td>
	</tr>
	<tr>
		<td>Last name:</td>
		<td><input type="text" name="lastName" value="${sessionScope.loginAccount.lastName}"/></td>
	</tr>
	<tr>
		<td>Email:</td>
		<td><input type="text" name="email" size="40" value="${sessionScope.loginAccount.email}" onblur="emailIsValid()"/></td>
		<td><div id="emailMsg"></div></td>
	</tr>
	<tr>
		<td>Phone:</td>
		<td><input type="text" name="phone" value="${sessionScope.loginAccount.phone}" onblur="phoneIsValid()"/></td>
		<td><div id="phoneMsg"></div></td>
	</tr>
	<tr>
		<td>Address 1:</td>
		<td><input type="text" name="address1" size="40" value="${sessionScope.loginAccount.address1}"/></td>
	</tr>
	<tr>
		<td>Address 2:</td>
		<td><input type="text" name="address2" size="40" value="${sessionScope.loginAccount.address2}"/></td>
	</tr>
	<tr>
		<td>City:</td>
		<td><input type="text" name="city" value="${sessionScope.loginAccount.city}"/></td>
	</tr>
	<tr>
		<td>State:</td>
		<td><input type="text" name="state" value="${sessionScope.loginAccount.state}"/></td>
	</tr>
	<tr>
		<td>Zip:</td>
		<td><input type="text" name="zip" size="10" value="${sessionScope.loginAccount.zip}" onblur=""/></td>
		<td><div id="zipMsg"></div></td>
	</tr>
	<tr>
		<td>Country:</td>
		<td><input type="text" name="country" size="15" value="${sessionScope.loginAccount.country}"/></td>
	</tr>
	<script language="javascript">
			function emailIsValid(){
				var email = document.registerForm.email.value;
				var div = document.getElementById("emailMsg");
				var reg = /^[a-zA-Z0-9_-]+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
				if(email.match(reg)){
					div.innerHTML = "<font color='green'>Email Valid</font>"
				}else{
					div.innerHTML = "<font color='red'>Email InValid</font>"
				}

			}

			function phoneIsValid(){
				var phone = document.registerForm.phone.value;
				var div = document.getElementById("phoneMsg");
				var reg = /^[1][358]\d{9}$/
				if(phone.match(reg)){
					div.innerHTML = "<font color='green'>Phone Valid</font>"
				}else{
					div.innerHTML = "<font color='red'>Phone InValid</font>"
				}
			}

			function zipIsValid(){
				var zip = document.registerForm.zip.value;
				var div = document.getElementById("zipMsg");
				var reg = /^\d{6}$/
				if(zip.match(reg)){
					div.innerHTML = "<font color='green'>Zip Valid</font>"
				}else{
					div.innerHTML = "<font color='red'>Zip InValid</font>"
				}
			}


	</script>
</table>

<h3>Profile Information</h3>

<table>
	<tr>
		<td>Language Preference:</td>
		<td>
			<select id="languagePreferenceId" name="languagePreference" >
				<option value="english" >english</option>
				<option value="japanese" >japanese</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>Favourite Category:</td>
		<td>
			<select id="favouriteCategoryIdSelect", name="favouriteCategoryId">
				<option value="BIRDS">BIRDS</option>
				<option value="CATS">CATS</option>
				<option value="DOGS">DOGS</option>
				<option value="FISH">FISH</option>
				<option value="REPTILES">REPTILES</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>Enable MyList</td>
		<td>
			<input type="checkbox" name="isListOption" />
		</td>
	</tr>
	<tr>
		<td>Enable MyBanner</td>
		<td>
			<input type="checkbox" name="isBannerOption" />
		</td>
	</tr>

</table>

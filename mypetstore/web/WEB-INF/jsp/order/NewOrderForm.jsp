<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
	<form action="continueOrder", method="post">
		<table>
			<tr>
				<th colspan=2>Payment Details</th>
			</tr>
			<tr>
				<td>Card Type:</td>
				<td>
					<select name="cardType">
						<option value="Visa" selected="selected">Visa</option>
						<option value="MasterCard">MasterCard</option>
						<option value="American">American</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Card Number:</td>
				<td><input type="text"  name="creditCard" value="9999999999999"/>* Use a fake
				number!</td>
			</tr>
			<tr>
				<td>Expiry Date (MM/YYYY):</td>
				<td><input type="text"  name="expiryDate" value="12/03"/></td>
			</tr>
			<tr>
				<th colspan=2>Billing Address</th>
			</tr>

			<tr>
				<td>First name:</td>
				<td><input type="text"  name="billToFirstName" value="${sessionScope.loginAccount.firstName}"/></td>
			</tr>
			<tr>
				<td>Last name:</td>
				<td><input type="text"  name="billToLastName" value="${sessionScope.loginAccount.lastName}"/></td>
			</tr>
			<tr>
				<td>Address 1:</td>
				<td><input type="text" size="40" name="billAddress1" value="${sessionScope.loginAccount.address1}"/></td>
			</tr>
			<tr>
				<td>Address 2:</td>
				<td><input type="text" size="40" name="billAddress2" value="${sessionScope.loginAccount.address2}"/></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="billCity" value="${sessionScope.loginAccount.city}"/></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><input type="text" size="14" name="billState" value="${sessionScope.loginAccount.state}"/></td>
			</tr>
			<tr>
				<td>Zip:</td>
				<td><input type="text" size="10" name="billZip" value="${sessionScope.loginAccount.zip}"/></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><input type="text" size="15" name="billCountry" value="${sessionScope.loginAccount.country}"/></td>
			</tr>

			<tr>
				<td colspan=2><input type="checkbox" name="shippingAddressRequired"/>
				Ship to different address...</td>
			</tr>

		</table>
		<input class="Button" type="submit" value="Continue"/>

	</form>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>
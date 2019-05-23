function getAccount(){
			
	let output = document.getElementById("AccountNo").value;
	axios.get('http://localhost:8080/accountapplication/rest/account/getAccount/' + output)
		.then(r => {
			let result = r.data;
			if(result !== null){
				document.getElementById("output").innerHTML = "First Name: " + result.firstName + "<br>Last Name: " + result.lastName + "<br>Account Number: " + result.accountNumber;
			}
			else{
				document.getElementById("output").innerHTML = "That account does not exist";
			}
		})
		.catch(e => {
			alert(e.toString());
		});
}

function getAllAccounts(){

	axios.get('http://localhost:8080/accountapplication/rest/account/getAllAccounts')
		.then(r => {
			let result = r.data;
			clearText();
			JSON.parse(result, null, "\t").forEach(a => {
				document.getElementById("outputAllFirstNameTitle").innerHTML += "First Name:<br>";
				document.getElementById("outputAllFirstNameValue").innerHTML += a.firstName + "<br>";
				document.getElementById("outputAllLastNameTitle").innerHTML += "Last Name:<br>";
				document.getElementById("outputAllLastNameValue").innerHTML += a.lastName + "<br>";
				document.getElementById("outputAllAccountNumberTitle").innerHTML += "Account:<br>";
				document.getElementById("outputAllAccountNumberValue").innerHTML += a.accountNumber + "<br>";
			})
		})
		.catch(e => {
			alert(e.toString());
		});
}

function makeAccount(){
	axios.post('http://localhost:8080/accountapplication/rest/account/addAccount', {
		firstName: document.getElementById("firstNameCreate").value,
		lastName: document.getElementById("lastNameCreate").value
	})
	.then(r => {
		let result = r.data;
		document.getElementById("outputCreate").innerHTML = JSON.stringify(result, null, "\t");
	})
	.catch(e => {
		alert(e.toString());
	});
}

function updateAccount(){
	axios.post('http://localhost:8080/accountapplication/rest/account/updateAccount', {
		firstName: document.getElementById("firstNameUpdate").value,
		lastName: document.getElementById("lastNameUpdate").value,
		accountNumber: document.getElementById("accountNumberUpdate").value
	})
	.then(r => {
		let result = r.data;
		document.getElementById("outputUpdate").innerHTML = JSON.stringify(result, null, "\t");
	})
	.catch(e => {
		alert(e.toString());
	});
}

function deleteAccount(){
	let output = document.getElementById("AccountNoDelete").value;
	axios.delete('http://localhost:8080/accountapplication/rest/account/deleteAccount/' + output)
		.then(r => {
			let result = r.data;
			document.getElementById("outputDelete").innerHTML = JSON.stringify(result, null, "\t");
		})
		.catch(e => {
			alert(e.toString());
		});
}

function clearText(){
	document.getElementById("output").innerHTML = "";
	document.getElementById("outputCreate").innerHTML = "";
	document.getElementById("outputUpdate").innerHTML = "";
	document.getElementById("outputDelete").innerHTML = "";
	document.getElementById("outputAllFirstNameTitle").innerHTML = "";
	document.getElementById("outputAllFirstNameValue").innerHTML = "";
	document.getElementById("outputAllLastNameTitle").innerHTML = "";
	document.getElementById("outputAllLastNameValue").innerHTML = "";
	document.getElementById("outputAllAccountNumberTitle").innerHTML = "";
	document.getElementById("outputAllAccountNumberValue").innerHTML = "";
}
let state = 'core'

fetchLogin = (event) => {
	let sessionData = {
		email: document.querySelector('#inputEmail').value,
		psw: document.querySelector('#inputPassword').value
	}

	// fetch('http://142.93.103.19:8080/api-certificami/user/register', {
	//   method: 'POST', // or 'PUT'
	//   headers: {
	//     'Content-Type': 'application/json',
	//   },
	//   body: JSON.stringify(sessionData),
	// })
	// .then((response) => response.json())
	// .then((data) => {
	//   console.log('Success:', data);
	// })
	// .catch((error) => {
	//   console.error('Error:', error);
	// });
	
	localStorage.setItem('authSession', JSON.stringify(sessionData.email));
	var retrievedObject = localStorage.getItem('authSession')
	console.log('authSession: ', JSON.parse(retrievedObject))
}

fetchRegister = (event) => {
	if (document.querySelector('#inputPassword').value === document.querySelector('#inputPasswordCheck').value) {
		let sessionPsw = document.querySelector('#inputPassword').value 
		let sessionData = {
			name: document.querySelector('#inputName').value,
			email: document.querySelector('#inputEmail').value,
			psw: document.querySelector('#inputPassword').value
		}

		// fetch('https://example.com/register', {
		//   method: 'POST', // or 'PUT'
		//   headers: {
		//     'Content-Type': 'application/json',
		//   },
		//   body: JSON.stringify(sessionData),
		// })
		// .then((response) => response.json())
		// .then((data) => {
		//   console.log('Success:', data);
		// })
		// .catch((error) => {
		//   console.error('Error:', error);
		// });

		localStorage.setItem('authSession', JSON.stringify(sessionData.email));
		var retrievedObject = localStorage.getItem('authSession') 
		console.log('authSession: ', JSON.parse(retrievedObject))
	}
	else {
		console.log('Psw non uguali')
	}

}


isValid = () => {
	document.querySelector('.form-div').classList.add('d-none') 
	document.querySelector('.core').classList.remove('d-none')
}

routeChange = (route) => {
	if (route === 'login') {
		document.querySelector('#submit').addEventListener('click', e => fetchLogin(e))
	} else if (route === 'register') {
		document.querySelector('.title').innerHTML = "Registrazione"
		document.querySelector('#submit').addEventListener('click', e => fetchRegister(e))
	} else if (route === 'core'){
		isValid()
	}
	console.log('route: ', route)

}






document.querySelector('#register').addEventListener('click', () => {
	document.querySelectorAll('.register').forEach(el => el.classList.remove('d-none'))
	document.querySelectorAll('.col-md-6')[0].classList.remove('col-md-6')
	document.querySelectorAll('.col-md-6')[0].classList.add('d-none')
	state = 'register'
	routeChange('register')
})


// Core


fetchCode = () => {
	fetch('https://helloacm.com/api/random/?n=128')
    .then((response) => {
            return response.json();
        })
        .then((data) => {
        		document.querySelector('.qrskele').style.display = "none"
                var qrcode = new QRCode(document.getElementById("qrcode"));
                makeCode = (hash) => qrcode.makeCode(hash)
                makeCode(data);

				localStorage.setItem('qrCode', JSON.stringify(data));
				var retrievedObject = localStorage.getItem('qrCode')
				console.log('qrCode: ', JSON.parse(retrievedObject))
  		});
	}


var retrievedObject = localStorage.getItem('authSession')

if (retrievedObject) {
	fetchCode()
} else {
	console.log('redirect')
}
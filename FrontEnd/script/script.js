let state = 'core'

let sessionData = {	
	name: "Ajeje Brazorff",
	email: "samuele@gmail.com",
	psw: "password",
	bornDate: "14/12/1915",
	bornCity: "Milano",
	bornProv: "MI",
	homeCity: "Milano",
	homeProv: "MI",
	homeStreet:"via storti 20",
	domCity:"Milano",
	domProv:"MI",
	domStreet:"via baglio 31",
	docs: "Patente",
	docsCode: "AY18478914AW",
	docsCity:"Milano",
	docsRelase:"14/12/1999",
	phone: "3489876542"
}

document.querySelector('#submit').addEventListener('click', e => fetchLogin(e))

fetchLogin = (event) => {
	let sessionData = {
		email: document.querySelector('#inputEmail').value,
		psw: document.querySelector('#inputPassword').value
	}

	fetch('http://142.93.103.19:8080/api-certificami/user/authenticate', {
	  method: 'POST', // or 'PUT'
	  headers: {
	    'Content-Type': 'application/json',
	  },
	  body: JSON.stringify(sessionData),
	})
	.then((response) => response.json())
	.then((data) => {
	  console.log('Success:', data);
	})
	.catch((error) => {
	  console.error('Error:', error);
	});
	
	localStorage.setItem('authSession', JSON.stringify(sessionData.email));
	var retrievedObject = localStorage.getItem('authSession')
	console.log('authSession: ', JSON.parse(retrievedObject))
}

firstRegistration = () => {

	if (document.querySelector('#inputPassword').value === document.querySelector('#inputPasswordCheck').value)
	{ 
			let sessionPsw = document.querySelector('#inputPassword').value 
			let sessionEmail = document.querySelector('#inputEmail').value
			let sessionName = document.querySelector('#inputName').value}
			else {

				console.log('Le password non corripondono')
			}
}

fetchRegister = (event) => {
	fetch('http://142.93.103.19:8080/api-certificami/user/register', {
	  method: 'POST', // or 'PUT'
	  headers: {
	    'Content-Type': 'application/json',
	  },
	  body: JSON.stringify(sessionData),
	}).then((response) => (response.status === 200) ? routeChange('info') : console.log('Errore durante la registrazione')
	).catch((err) => console.log(err))
	// localStorage.setItem('authSession', JSON.stringify(sessionData.email));
	// var retrievedObject = localStorage.getItem('authSession') 
	// console.log('authSession: ', JSON.parse(retrievedObject))

}


isValid = () => {
	document.querySelector('.public').classList.add('d-none') 
	document.querySelector('.core').classList.remove('d-none')
}





routeChange = (route) => {
	if (route === 'login') {
		document.querySelector('#submit').removeEventListener('click', e => fetchRegister(e))
		document.querySelector('#submit').addEventListener('click', e => fetchLogin(e))
	} else if (route === 'register') {
		document.querySelector('#submit').removeEventListener('click', e => fetchLogin(e))
		document.querySelector('.title').innerHTML = "Registrazione"
		document.querySelector('#submit').addEventListener('click', e => fetchRegister(e))
	} else if (route === 'info') {
		document.querySelector('.frame-maker').classList.remove('d-none')
		document.querySelector('.login-register').classList.add('d-none')


	} else if (route === 'core') {
		isValid()
	}
	console.log('route: ', route)

}





// Morph the login in register
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



// info spostamento 

fetchMove = () => {
	let infoMock = {
		email: "samuele@gmail.com",
		moveStreetStart:"Via Brazorff 31",
		moveStreetEnd: "Via cadorna 34",
		moveRegStart:"Lombardia",
		moveRegEnd:"Piemonte",
		ragioneText:"Consegna merci fragili",
		ragioneOption: 2,// Checkbox 0,1,2,3 
		ragioneOptionText: "Il mio capo mi licenzia se non vado"
	}
	


	fetch('http://142.93.103.19:8080/api-certificami/certificate', {
		  method: 'POST', // or 'PUT'
		  headers: {
		    'Content-Type': 'application/json',
		  },
		  body: JSON.stringify(infoMock),
		}).then((response) => console.log(response)).catch((err) => console.log(err))
}


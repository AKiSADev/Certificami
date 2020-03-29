let state = 'core'



let sessionData = {
  	name: "admin admin",
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
	phone: "3489876542",
	email:"email@gmail.com"
}

let moveChunk = {
	email: "ciao@ciao.com",
  moveStreetStart:"Via Brazorff 31",
  moveStreetEnd: "Via cadorna 34",
  moveRegStart:"Lombardia",
  moveRegEnd:"Piemonte",
  ragioneText:"Consegna merci fragili",
  ragioneOption: 2,// Checkbox 0,1,2,3 
  ragioneOptionText: "Il mio capo mi licenzia se non vado"
}



document.querySelector('#submit').addEventListener('click', e => fetchLogin(e))

fetchLogin = (event) => {
	let loginData = {
		email: document.querySelector('#inputEmail').value,
		psw: document.querySelector('#inputPassword').value
	}

	fetch('http://142.93.103.19:8080/api-certificami/user/authenticate', {
	  method: 'POST', // or 'PUT'
	  headers: {
	    'Content-Type': 'application/json',
	  },
	  body: JSON.stringify(loginData),
	})
	.then((response) => {if (response.status === 200) {
		routeChange('info')
	}
})
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

		fetch('http://142.93.103.19:8080/api-certificami/user/register', {
		  method: 'POST', // or 'PUT'
		  headers: {
		    'Content-Type': 'application/json',
		  },
		  body: JSON.stringify({
		  		psw: document.querySelector('#inputPassword').value,
				email: document.querySelector('#inputEmail').value,
				name: document.querySelector('#inputName').value
		  	}),
		}).then((response) => console.log(response)
		).catch((err) => console.log(err))

		sessionData.psw = document.querySelector('#inputPassword').value 
		sessionData.email = document.querySelector('#inputEmail').value
		sessionData.name = document.querySelector('#inputName').value

		routeChange('info')
	}
			else {

				console.log('Le password non corripondono')
			}
}

fetchInformation = (event) => {
	let infoPersonal = {
		email: sessionData.email,
		bornDate: document.querySelector('#bornDate').value,
		bornCity: document.querySelector('#bornCity').value,
		bornProv: document.querySelector('#bornProv').value,
		homeCity: document.querySelector('#homeCity').value,
		homeProv: document.querySelector('#homeProv').value,
		homeStreet: document.querySelector('#homeStreet').value,
		homeCity: document.querySelector('#homeCity').value,
		homeProv: document.querySelector('#homeProv').value,
		homeStreet: document.querySelector('#homeStreet').value,
		docs: document.querySelector('#docs').value,
		docsCode: document.querySelector('#docsCode').value,
		bornCity: document.querySelector('#bornCity').value,
		docsRelase: document.querySelector('#docsRelase').value,
		phone: document.querySelector('#phone').value
	}


	fetch('http://142.93.103.19:8080/api-certificami/user/information', {
	  method: 'POST', // or 'PUT'
	  headers: {
	    'Content-Type': 'application/json',
	  },
	  body: JSON.stringify(infoPersonal),
	}).then((response) => console.log(response)
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
		console.log('back login')
	} else if (route === 'register') {
		document.querySelector('#submit').classList.add('d-none')
		document.querySelector('#register').classList.add('d-none')
		document.querySelector('#submit-reg').classList.remove('d-none')
		document.querySelector('.title').innerHTML = "Registrazione"
		document.querySelectorAll('.register').forEach(el=> el.classList.remove('d-none'))
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





// info spostamento 

fetchMove = () => {
let moveSession = {
	email: document.querySelector('#inputEmail').value,
  	moveStreetStart:document.querySelector('#moveStreetStart').value,
  	moveStreetEnd: document.querySelector('#moveStreetEnd').value,
  	moveRegStart: document.querySelector('#moveRegStart').value,
  	moveRegEnd: document.querySelector('#moveRegEnd').value,
  	ragioneText: 'Ragione urgente standard',
  	ragioneOption: 0,// Checkbox 0,1,2,3 
  	ragioneOptionText: document.querySelector('#ragioneOptionText').value
}


	fetch('http://142.93.103.19:8080/api-certificami/certificate', {
	  method: 'POST', // or 'PUT'
	  headers: {
	    'Content-Type': 'application/json',
	  },
	  body: JSON.stringify(moveSession),
	}).then((response) => {
            return response.json();
        })
        .then((data) => {
        		document.querySelector('.qrskele').style.display = "none"
                var qrcode = new QRCode(document.getElementById("qrcode"));
                makeCode = (hash) => qrcode.makeCode(hash)
                makeCode(data);

				localStorage.setItem('qrCode', JSON.stringify(data));
				var retrievedObject = localStorage.getItem('qrCode')
				routeChange('core')
				console.log('qrCode: ', JSON.parse(retrievedObject))
  		}).catch((err) => console.log(err))
}


const slidingContainer = document.querySelector('.sliding-container') 
function stepMove (e) { 
 let percentage = e * 100 
 slidingContainer.style.left = `-${percentage}% `
}

function Sottoscrivi () {
	fetchInformation()
	fetchMove()
}
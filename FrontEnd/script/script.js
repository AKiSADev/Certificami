let state = 'core'



let sessionData = {
    name: "admin admin",
    bornDate: "14/12/1915",
    bornCity: "Milano",
    bornProv: "MI",
    homeCity: "Milano",
    homeProv: "MI",
    homeStreet: "via storti 20",
    domCity: "Milano",
    domProv: "MI",
    domStreet: "via baglio 31",
    docs: "Patente",
    docsCode: "AY18478914AW",
    docsCity: "Milano",
    docsRelase: "14/12/1999",
    phone: "3489876542",
    email: "ciao@ciao.com",
    moveChunk: {
        email: "ciao@ciao.com",
        moveStreetStart: "Via Brazorff 31",
        moveStreetEnd: "Via cadorna 34",
        moveRegStart: "Lombardia",
        moveRegEnd: "Piemonte",
        ragioneText: "Consegna merci fragili",
        ragioneOption: 2, // Checkbox 0,1,2,3 
        ragioneOptionText: "Il mio capo mi licenzia se non vado"
    }
}

// Login

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
	}).then((response) => (response.status === 200) ? initSessionData(loginData) : console.log('Login error')
	).catch((error) => console.error('Error:', error))
	
	
}

// Morph the login in register
document.querySelector('#register').addEventListener('click', () => {
	document.querySelectorAll('.register').forEach(el => el.classList.remove('d-none'))
	document.querySelectorAll('.col-md-6')[0].classList.remove('col-md-6')
	document.querySelectorAll('.col-md-6')[0].classList.add('d-none')
	state = 'register'
	routeChange('register')
})

//Register
firstRegistration = () => {
	if (document.querySelector('#inputPassword').value === document.querySelector('#inputPasswordCheck').value)
	{ 
		registerData = {
			psw: document.querySelector('#inputPassword').value,
			email: document.querySelector('#inputEmail').value,
			name: document.querySelector('#inputName').value
		}

		if (registerData.psw.length < 7 && registerData.name.length < 1 && registerData.email.lenght < 1 ) {
			console.log('data too short')
			return
		} else {
			fetch('http://142.93.103.19:8080/api-certificami/user/register', {
			  method: 'POST',
			  headers: {'Content-Type': 'application/json',},
			  body: JSON.stringify(registerData),
			}).then((response) => (response.status === 200) ? initSessionData(registerData) : console.log('Registrazione error')
			).catch((err) => console.log(err))}
				
		} else {
			console.log('Le password non corripondono')
		}		
}

checkSessionData = (route) => {
	// Print the saved data
	var retrievedObject = localStorage.getItem('authSession')
	console.log('authSession: ', JSON.parse(retrievedObject))
	routeChange(route)
}


initSessionData = (data) => {
	localStorage.setItem('authSession', JSON.stringify(data));
	checkSessionData('info')

}

convertDate = (date) => `${date.split('-')[2]}/${date.split('-')[1]}/${date.split('-')[0]}`


fetchInformation = (event) => {
	sessionData.name = document.querySelector('#name').value
	sessionData.bornDate = convertDate(document.querySelector('#bornDate').value)
	sessionData.bornCity = document.querySelector('#bornCity').value
	sessionData.bornProv = document.querySelector('#bornProv').value
	sessionData.homeCity = document.querySelector('#homeCity').value
	sessionData.homeProv = document.querySelector('#homeProv').value
	sessionData.homeStreet = document.querySelector('#homeStreet').value
	sessionData.domCity = document.querySelector('#homeCity').value
	sessionData.domProv = document.querySelector('#homeProv').value
	sessionData.domStreet = document.querySelector('#homeStreet').value
	sessionData.docs = document.querySelector('#docs').value
	sessionData.docsCode = document.querySelector('#docsCode').value
	sessionData.docsCity = document.querySelector('#docsCity').value
	sessionData.docsRelase = convertDate(document.querySelector('#bornDate').value)
	sessionData.phone = document.querySelector('#phone').value
	sessionData.email = document.querySelector('#inputEmail').value

	fetch('http://142.93.103.19:8080/api-certificami/user/information', {
	  method: 'POST', 
	  headers: {
	    'Content-Type': 'application/json',
	  },
	  body: JSON.stringify(sessionData),
	}).then((response) => (response.status === 200) ? console.log('ok') : console.log('Registrazione error')
	).catch((err) => console.log(err))

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
// info spostamento 

fetchMove = () => {
    sessionData.moveChunk.email = document.querySelector('#inputEmail').value,
    sessionData.moveChunk.moveStreetStart = document.querySelector('#moveStreetStart').value,
    sessionData.moveChunk.moveStreetEnd = document.querySelector('#moveStreetEnd').value,
    sessionData.moveChunk.moveRegStart = document.querySelector('#moveRegStart').value,
    sessionData.moveChunk.moveRegEnd = document.querySelector('#moveRegEnd').value,
    sessionData.moveChunk.ragioneText = document.querySelector('#ragioneText').value,
    sessionData.moveChunk.ragioneOption = document.querySelector('#ragioneOption').value,
    sessionData.moveChunk.ragioneOptionText = document.querySelector('#ragioneOptionText').value

    fetch('http://142.93.103.19:8080/api-certificami/certificate', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(moveSession),
        }).then((response) => {
            return response.json();
        }).then((id) => loadCertificationCode(id)).catch((err) => console.log(err))
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


loadCertificationCode = (certificationId) => {
	document.querySelector('.qrskele').style.display = "none"
    var qrcode = new QRCode(document.getElementById("qrcode"));
    makeCode = (hash) => qrcode.makeCode(hash)
    makeCode(`google.com?idCert=${certificationId}`);

	localStorage.setItem('qrCode', JSON.stringify(certificationId));
	var retrievedObject = localStorage.getItem('qrCode')
	routeChange('core')
	console.log('qrCode: ', JSON.parse(retrievedObject))
}
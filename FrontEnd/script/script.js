let state = 'login'

fetchLogin = (event) => {
	let sessionData = {
		email: document.querySelector('#inputEmail').value,
		psw: document.querySelector('#inputPassword').value
	}

	fetch('https://example.com/profile', {
	  method: 'POST', // or 'PUT'
	  headers: {
	    'Content-Type': 'application/json',
	  },
	  body: JSON.stringify(data),
	})
	.then((response) => response.json())
	.then((data) => {
	  console.log('Success:', data);
	})
	.catch((error) => {
	  console.error('Error:', error);
	});
	
	// localStorage.setItem('authSession', JSON.stringify(sessionData.email));
	// var retrievedObject = localStorage.getItem('authSession')
	// console.log('authSession: ', JSON.parse(retrievedObject))
}

fetchRegister = (event) => {
	if (document.querySelector('#inputPassword').value === document.querySelector('#inputPasswordCheck').value) {
		let sessionPsw = document.querySelector('#inputPassword').value 
		let sessionData = {
			name: document.querySelector('#inputName').value,
			email: document.querySelector('#inputEmail').value,
			psw: document.querySelector('#inputPassword').value
		}

		fetch('https://example.com/register', {
		  method: 'POST', // or 'PUT'
		  headers: {
		    'Content-Type': 'application/json',
		  },
		  body: JSON.stringify(data),
		})
		.then((response) => response.json())
		.then((data) => {
		  console.log('Success:', data);
		})
		.catch((error) => {
		  console.error('Error:', error);
		});

		// localStorage.setItem('authSession', JSON.stringify(sessionData.email));
		// var retrievedObject = localStorage.getItem('authSession') 
		// console.log('authSession: ', JSON.parse(retrievedObject))
	}
	else {
		console.log('Psw non uguali')
	}

}

(state === 'login') ? document.querySelector('#submit').addEventListener('click', e => fetchLogin(e)) 
: document.querySelector('#submit').addEventListener('click', e => fetchRegister(e));


document.querySelector('#register').addEventListener('click', () => {
	document.querySelectorAll('.d-none').forEach(el => el.classList.remove('d-none'))
	document.querySelectorAll('.col-md-6')[0].classList.remove('col-md-6')
	document.querySelectorAll('.col-md-6')[0].classList.add('d-none')
	state = 'register'
})


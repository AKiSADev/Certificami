document.querySelector('#submit').addEventListener('click', event => {
	let sessionData = {
		email: document.querySelector('#inputEmail').value,
		psw: document.querySelector('#inputPassword').value
	}

	localStorage.setItem('authSession', JSON.stringify(sessionData.email));
	var retrievedObject = localStorage.getItem('authSession')
	console.log('authSession: ', JSON.parse(retrievedObject))
	
});

document.querySelector('#register').addEventListener('click', () => {
	document.querySelectorAll('.d-none').forEach(el => el.classList.remove('d-none'))
	document.querySelectorAll('.col-md-6')[0].classList.remove('col-md-6')
	document.querySelectorAll('.col-md-6')[0].classList.add('d-none')

})


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


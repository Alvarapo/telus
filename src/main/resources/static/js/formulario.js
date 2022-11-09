
const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');

const expresiones = {
	username: /^[a-zA-ZÀ-ÿ\s]{1,40}$/, // Letras y espacios, pueden llevar acentos.
	name: /^[a-zA-ZÀ-ÿ\s]{1,60}$/,
	password: /^.{4,12}$/, // 4 a 12 digitos.
	email: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/
}

const campos = {
	username: false,
	name: false,
	password: false,
	email: false
}


const validarFormulario = (e) => {
	switch (e.target.name) {
		case "username":
			validarCampo(expresiones.username, e.target, 'username');
		break;
		case "name":
        	validarCampo(expresiones.name, e.target, 'name');
        break;
		case "password":
			validarCampo(expresiones.password, e.target, 'password');
			validarPassword2();
		break;
		case "password2":
			validarPassword2();
		break;
		case "email":
			validarCampo(expresiones.email, e.target, 'email');
		break;
	
	}
}


const validarCampo = (expresion, input, campo) => {
	if(expresion.test(input.value)){
		document.getElementById(`grupo__${campo}`).classList.remove('input-contenedor-incorrecto');
		document.getElementById(`grupo__${campo}`).classList.add('input-contenedor-correcto');
		document.querySelector(`#grupo__${campo} i`).classList.add('fa-check-circle');
		document.querySelector(`#grupo__${campo} i`).classList.remove('fa-times-circle');
		document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.remove('formulario__input-error-activo');
		
		campos[campo] = true;
	} else {
		document.getElementById(`grupo__${campo}`).classList.add('input-contenedor-incorrecto');
		document.getElementById(`grupo__${campo}`).classList.remove('input-contenedor-correcto');
		document.querySelector(`#grupo__${campo} i`).classList.add('fa-times-circle');
		document.querySelector(`#grupo__${campo} i`).classList.remove('fa-check-circle');
		document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.add('formulario__input-error-activo');
	
		campos[campo] = false;
	}
	
	if(campos.username && campos.name && campos.password && campos.email){
		document.getElementById('sing-in').disabled= false;
		
	}else{
		document.getElementById('sing-in').disabled= true;
	}
}

const validarPassword2 = () => {
	const inputPassword1 = document.getElementById('password');
	const inputPassword2 = document.getElementById('password2');

	if(inputPassword1.value !== inputPassword2.value){
		document.getElementById(`grupo__password2`).classList.add('input-contenedor-incorrecto');
		document.getElementById(`grupo__password2`).classList.remove('input-contenedor-correcto');
		document.querySelector(`#grupo__password2 i`).classList.add('fa-times-circle');
		document.querySelector(`#grupo__password2 i`).classList.remove('fa-check-circle');
		document.querySelector(`#grupo__password2 .formulario__input-error`).classList.add('formulario__input-error-activo');
		campos['password'] = false;
	} else {
		document.getElementById(`grupo__password2`).classList.remove('input-contenedor-incorrecto');
		document.getElementById(`grupo__password2`).classList.add('input-contenedor-correcto');
		document.querySelector(`#grupo__password2 i`).classList.remove('fa-times-circle');
		document.querySelector(`#grupo__password2 i`).classList.add('fa-check-circle');
		document.querySelector(`#grupo__password2 .formulario__input-error`).classList.remove('formulario__input-error-activo');
		campos['password'] = true;
	}
}



inputs.forEach((input) => { //por cada input ejecuto
	input.addEventListener('keyup', validarFormulario);  //cuando el usuario pulsa una tecla valido formulario, (cuando escribe)
	input.addEventListener('blur', validarFormulario); //cuando hace clcik fuera del input
});


formulario.addEventListener('submit', (e) => {   //cuando le de click al boton ejecuto una funcion

});
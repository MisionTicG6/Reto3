/////////////////////////////////////////////////////FUNCIONES CAR////////////////////////////////////////////////////////////

function leerCarros() {
    $.ajax({
        url: "http://localhost:8080/api/Car/all",
        type: 'GET',
        dataType: 'JSON',

        success: function (respuesta) {

            pintarCarros(respuesta.items);

        },
        error: function (xhr, status) {
            alert("error");
        }
    }

    )
}

function pintarCarros(items) {

    $("#listaCarros").empty();

    //declarar variables js
    let myTable = "<table>";
    myTable += "<tr><th>Marca</th><th>Nombre</th><th>Modelo</th><th>Descripcion</th><th>Gama</th></tr>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].brand + "</td>";
        myTable += "<td>" + items[i].name + "</td>";
        myTable += "<td>" + items[i].model + "</td>";
        myTable += "<td>" + items[i].descripcion + "</td>";
        myTable += "<td>" + items[i].gama + "</td>";
        //myTable += "<td><button onclick='borrarCarro(" + items[i].id + ")'>Borrar</button>";
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#listaCarros").append(myTable);
}

function guardarCarro() {
    //Obtiene los valores de los input del formulario
    let brandCar = $("#brandCar").val();
    let nameCar = $("#nameCar").val();
    let modelCar = $("#modelCar").val();
    let descriptionCar = $("#descriptionCar").val();
    let gamaCar = $("#gamaCar").val();

    //guarda los datos del formulario en un arreglo
    let data = {
        id: brandCar,
        brand: nameCar,
        model: modelCar,
        category_id: descriptionCar,
        gamaCar: gamaCar
    };

    //convierte el arreglo en formato JSON
    let dataToSend = JSON.stringify(data);


    $.ajax({
        url: "http://localhost:8080/api/Car/save",
        type: 'POST',
        //dataType: 'JSON',
        data: dataToSend,
        contentType: 'application/json',

        success: function (anything) {
            $("#brandCar").val("");
            $("#nameCar").val("");
            $("#modelCar").val("");
            $("#descriptionCar").val("");
            $("#gamaCar").val("");
        },
        error: function (xhr, status) {
            alert("error");
        }
    }

    );
}



////////////////////////////////////////////////////FUNCIONES GAMA/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////7
function leerGama() {
    $.ajax({
        url: "",
        type: 'GET',
        dataType: 'JSON',

        success: function (respuesta) {

            pintarGama(respuesta.items);

            // let cs=respuesta.items;

            // for(i=0;i<cs.length;i++){
            //     $("#listaClientes").append(cs[i].name);

            // }
        },
        error: function (xhr, status) {
            alert("error");
        }
    }

    )
}

function pintarGama(items) {

    $("#listaGama").empty();

    //declarar variables js
    let myTable = "<table>";
    myTable += "<tr><th>Nombre</th><th>Descripción</th> </tr>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].nameGama + "</td>";
        myTable += "<td>" + items[i].descriptionGama + "</td>";
        //myTable += "<td><button onclick='borrarMensaje(" + items[i].id + ")'>Borrar</button>";
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#listaGama").append(myTable);
}

function guardarGama() {
    //Obtiene los valores de los input del formulario
    let nameGama = $("#nameGama").val();
    let descriptionGama = $("#descriptionGama").val();


    //guarda los datos del formulario en un arreglo
    let data = {
        nameGama: nameGama,
        descriptionGama: descriptionGama,
    };

    //convierte el arreglo en formato JSON
    let dataToSend = JSON.stringify(data);


    $.ajax({
        url: "",
        type: 'POST',
        //dataType: 'JSON',
        data: dataToSend,
        contentType: 'application/json',

        success: function (anything) {
            $("#nameGama").val("");
            $("#descriptionGama").val("");
        },
        error: function (xhr, status) {
            alert("error");
        }
    }

    );
}

///////////////////////////////////////////////////FUNCIONES CLIENTE/////////////////////////////////////////////////////////////////////

function leerClientes() {
    $.ajax({
        url: "",
        type: 'GET',
        dataType: 'JSON',

        success: function (respuesta) {

            pintarClientes(respuesta.items);

            // let cs=respuesta.items;

            // for(i=0;i<cs.length;i++){
            //     $("#listaClientes").append(cs[i].name);

            // }
        },
        error: function (xhr, status) {
            alert("error");
        }
    }

    )
}

function pintarClientes(items) {

    $("#listaClientes").empty();

    //declarar variables js
    let myTable = "<table>";
    myTable += "<tr><th>Nombre</th><th>Correo</th><th>Edad</th><th>Contraseña</th></tr>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";;
        myTable += "<td>" + items[i].name + "</td>";
        myTable += "<td>" + items[i].email + "</td>";
        myTable += "<td>" + items[i].age + "</td>";
        myTable += "<td>" + items[i].password + "</td>"
        //myTable += "<td><button onclick='borrarCliente(" + items[i].id + ")'>Borrar</button>";
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#listaClientes").append(myTable);
}

function guardarCliente() {
    //Obtiene los valores de los input del formulario
    let nombre = $("#nameClient").val();
    let correo = $("#mailClient").val();
    let edad = $("#ageClient").val();
    let password = $("#passwordClient").val();

    //guarda los datos del formulario en un arreglo
    let data = {
        
        name: nombre,
        email: correo,
        age: edad,
        password: password
    };

    //convierte el arreglo en formato JSON
    let dataToSend = JSON.stringify(data);


    $.ajax({
        url: "",
        type: 'POST',
        //dataType: 'JSON',
        data: dataToSend,
        contentType: 'application/json',

        success: function (algo) {
            $("#nameClient").val("");
            $("#mailClient").val("");
            $("#ageClient").val("");
            $("#passwordClient").val("");
        },
        error: function (xhr, status) {
            alert("error");
        }
    }

    );
}



////////////////////////////////////////////////FUNCIONES MENSAJE/////////////////////////////////////////////////////////////////////////////////////

function leerMensajes() {
    $.ajax({
        url: "",
        type: 'GET',
        dataType: 'JSON',

        success: function (respuesta) {

            pintarMensajes(respuesta.items);

            // let cs=respuesta.items;

            // for(i=0;i<cs.length;i++){
            //     $("#listaClientes").append(cs[i].name);

            // }
        },
        error: function (xhr, status) {
            alert("error");
        }
    }

    )
}

function pintarMensajes(items) {

    $("#listaMensajes").empty();

    //declarar variables js
    let myTable = "<table>";
    myTable += "<tr><th>Mensaje</th> </tr>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].messagetext + "</td>";
        //myTable += "<td><button onclick='borrarMensaje(" + items[i].id + ")'>Borrar</button>";
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#listaMensajes").append(myTable);
}

function guardarMensaje() {
    //Obtiene los valores de los input del formulario
    let mensaje = $("#mensaje").val();


    //guarda los datos del formulario en un arreglo
    let data = {
        messagetext: mensaje,
    };

    //convierte el arreglo en formato JSON
    let dataToSend = JSON.stringify(data);


    $.ajax({
        url: "",
        type: 'POST',
        //dataType: 'JSON',
        data: dataToSend,
        contentType: 'application/json',

        success: function (anything) {

            $("#mensaje").val("");
        },
        error: function (xhr, status) {
            alert("error");
        }
    }

    );
}

//////////////////////////////////////////////////////////////FUNCIONES RESERVA////////////////////////////////////////////////////////////////

function leerReservas() {
    $.ajax({
        url: "",
        type: 'GET',
        dataType: 'JSON',

        success: function (respuesta) {

            pintarReservas(respuesta.items);

            // let cs=respuesta.items;

            // for(i=0;i<cs.length;i++){
            //     $("#listaClientes").append(cs[i].name);

            // }
        },
        error: function (xhr, status) {
            alert("error");
        }
    }

    )
}

function pintarReservas(items) {

    $("#listaReservas").empty();

    //declarar variables js
    let myTable = "<table>";
    myTable += "<tr><th>Carrp</th><th>Cliente</th><th>FechaInicio</th><th>FechaEntrega</th></tr>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";;
        myTable += "<td>" + items[i].reservaCar + "</td>";
        myTable += "<td>" + items[i].reservaClient + "</td>";
        myTable += "<td>" + items[i].FechaInicio + "</td>";
        myTable += "<td>" + items[i].FechaEntrega + "</td>"
        //myTable += "<td><button onclick='borrarCliente(" + items[i].id + ")'>Borrar</button>";
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#listaReservas").append(myTable);
}

function guardarCliente() {
    //Obtiene los valores de los input del formulario
    let carro = $("#reservaCar").val();
    let cliente = $("#reservaClient").val();
    let inicio = $("#fechaInicio").val();
    let entrega = $("#fechaEntrega").val();

    //guarda los datos del formulario en un arreglo
    let data = {
        
        car: carro,
        client: cliente,
        inicio: inicio,
        entrega: entrega
    };

    //convierte el arreglo en formato JSON
    let dataToSend = JSON.stringify(data);


    $.ajax({
        url: "",
        type: 'POST',
        //dataType: 'JSON',
        data: dataToSend,
        contentType: 'application/json',

        success: function (algo) {
            $("#reservaCar").val("");
            $("#reservaClient").val("");
            $("#fechaInicio").val("");
            $("#fechaEntrega").val("");
        },
        error: function (xhr, status) {
            alert("error");
        }
    }

    );
}

////////////////////////////////////////////////////////////////////////FUNCIONES SCORE_RESERVAS/////////////////////////////////////

function leerScoreReservas() {
    $.ajax({
        url: "",
        type: 'GET',
        dataType: 'JSON',

        success: function (respuesta) {

            pintarScoreReservas(respuesta.items);

            // let cs=respuesta.items;

            // for(i=0;i<cs.length;i++){
            //     $("#listaClientes").append(cs[i].name);

            // }
        },
        error: function (xhr, status) {
            alert("error");
        }
    }

    )
}

function pintarScoreReservas(items) {

    $("#listaScoreReservas").empty();

    //declarar variables js
    let myTable = "<table>";
    myTable += "<tr><th>Calificación</th><th>Mensaje</th><th>Reserva</th></tr>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";;
        myTable += "<td>" + items[i].scoreReserva + "</td>";
        myTable += "<td>" + items[i].mensajeReserva + "</td>";
        myTable += "<td>" + items[i].idReserva + "</td>";
        //myTable += "<td><button onclick='borrarCliente(" + items[i].id + ")'>Borrar</button>";
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#listaScoreReservas").append(myTable);
}

function guardarCliente() {
    //Obtiene los valores de los input del formulario
    let scoreReserva = $("#scoreReserva").val();
    let mensajeReserva = $("#mensajeReserva").val();
    let idReserva = $("#idReserva").val();


    //guarda los datos del formulario en un arreglo
    let data = {
        
        scoreReserva: scoreReserva,
        mensajeReserva: mensajeReserva,
        idReserva: idReserva,
    };

    //convierte el arreglo en formato JSON
    let dataToSend = JSON.stringify(data);


    $.ajax({
        url: "",
        type: 'POST',
        //dataType: 'JSON',
        data: dataToSend,
        contentType: 'application/json',

        success: function (algo) {
            $("#scoreReserva").val("");
            $("#mensajeReserva").val("");
            $("idReserva").val("");
        },
        error: function (xhr, status) {
            alert("error");
        }
    }

    );
}

////////////////////////////////////////////////////////////FUNCIONES ADMIN//////////////////////////////////////////////////////////////////////////////////////////

function leerAdmin() {
    $.ajax({
        url: "",
        type: 'GET',
        dataType: 'JSON',

        success: function (respuesta) {

            pintarAdmin(respuesta.items);

            // let cs=respuesta.items;

            // for(i=0;i<cs.length;i++){
            //     $("#listaClientes").append(cs[i].name);

            // }
        },
        error: function (xhr, status) {
            alert("error");
        }
    }

    )
}

function pintarAdmin(items) {

    $("#listaAdmin").empty();

    //declarar variables js
    let myTable = "<table>";
    myTable += "<tr><th>Nombre</th><th>Correo</th><th>Contraseña</th></tr>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";;
        myTable += "<td>" + items[i].nameAdmin + "</td>";
        myTable += "<td>" + items[i].mailAdmin + "</td>";
        myTable += "<td>" + items[i].passwordAdmin + "</td>";
        //myTable += "<td><button onclick='borrarCliente(" + items[i].id + ")'>Borrar</button>";
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#listaAdmin").append(myTable);
}

function guardarAdmin() {
    //Obtiene los valores de los input del formulario
    let nameAdmin = $("#nameAdmin").val();
    let mailAdmin = $("#mailAdmin").val();
    let passwordAdmin = $("#passwordAdmin").val();

    //guarda los datos del formulario en un arreglo
    let data = {
        
        nameAdmin: nameAdmin,
        mailAdmin: mailAdmin,
        passwordAdmin: passwordAdmin,
    };

    //convierte el arreglo en formato JSON
    let dataToSend = JSON.stringify(data);


    $.ajax({
        url: "",
        type: 'POST',
        //dataType: 'JSON',
        data: dataToSend,
        contentType: 'application/json',

        success: function (algo) {
            $("#nameAdmin").val("");
            $("#mailAdmin").val("");
            $("#passwordAdmin").val("");
        },
        error: function (xhr, status) {
            alert("error");
        }
    }

    );
}

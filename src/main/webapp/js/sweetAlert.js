$(document).ready(function () {

    $('.delete').click((function (event) {

        event.preventDefault();

        Swal.fire({
            title: 'Estas seguro?',
            text: "No se podra revertir!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Aceptar!',
            cancelButtonText: 'Cancelar'

        }).then((result) => {
            if (result.isConfirmed) {
                window.location = this.href;
            }
        }
        )
    }
    ))
});





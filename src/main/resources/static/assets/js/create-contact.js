$(() => {
    const controls = {
        tabCreate: {

        },
        tabImport: {
            alertSuccess: $('#contact-alert-success'),
            alertError: $('#contact-alert-error'),
            uploadContent: $('#contact-upload-content'),
            inputFile: $('#contact-input'),
            fileName: $('#contact-file-name'),
            fileSize: $('#contact-file-size'),
            btnUpload: $('#btn-upload'),
            btnRemove: $('#btn-remove'),
            loader: $('#contact-loader')
        }
    };

    controls.tabImport.uploadContent.click(function (e) {
        e.preventDefault();

        controls.tabImport.inputFile.trigger('click');
    });

    controls.tabImport.inputFile.change(function (e) {
        const file = e.target.files[0];
        console.log(file);

        controls.tabImport.fileName.text(file.name);
        controls.tabImport.fileSize.text(file.size);
    });

    controls.tabImport.btnUpload.click(function (e) {
       e.preventDefault();

       controls.tabImport.loader.removeClass('hidden');

       setTimeout(function (e) {
           controls.tabImport.loader.addClass('hidden');
           controls.tabImport.alertSuccess.removeClass('hidden');
       }, 5000);
    });

    controls.tabImport.btnRemove.click(function (e) {
        e.preventDefault();

        controls.tabImport.inputFile.val(null);
        controls.tabImport.loader.addClass('hidden');
        controls.tabImport.alertSuccess.addClass('hidden');
        controls.tabImport.alertError.addClass('hidden');
        controls.tabImport.fileName.text('');
        controls.tabImport.fileSize.text('');
    })
});

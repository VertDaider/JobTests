YUI().use(
    'aui-datepicker',
    'aui-form-validator',
    function(Y) {
        new Y.DatePicker(
            {
                trigger: '#<portlet:namespace />firstDate',
                mask: '%d.%m.%Y',
                popover: {
                    zIndex: 1
                },
                on: {
                    selectionChange: function(event) {
                        console.log(event.newSelection)
                    }
                }
            }

        );
        new Y.DatePicker(
            {
                trigger: '#<portlet:namespace />lastDate',
                mask: '%d.%m.%Y',
                popover: {
                    zIndex: 1
                },
                on: {
                    selectionChange: function(event) {
                        console.log(event.newSelection)
                    }
                }
            }
        );
    }
);
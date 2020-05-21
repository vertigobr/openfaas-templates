# openfaas-templates

OpenFaas function templates for Vertigo iPaaS

This is the default repo for Vertigo iPaaS command-line utility (safira).

To use these funtions with plain `faas-cli` you can do any of these options:

### 1. OPENFAAS_TEMPLATE_STORE_URL environment variable

```sh
export OPENFAAS_TEMPLATE_STORE_URL="https://raw.githubusercontent.com/vertigobr/openfaas-templates/master/templates.json"
faas-cli template store pull a_template_name
```

### 2. Template pull

```sh
faas-cli template pull https://github.com/vertigobr/openfaas-templates
```


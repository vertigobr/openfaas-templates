# openfaas-templates

OpenFaas function templates for Vertigo iPaaS.

This is the default repo for Vertigo iPaaS command-line utility (safira):

```sh
safira template list

NAME                   SOURCE    DESCRIPTION
vtg-ipaas-python3      vertigobr Classic Python 3.6 template
vtg-ipaas-java11-maven vertigobr Java 11 Maven template
vtg-ipaas-java8-maven  vertigobr Java 8 Maven template
vtg-ipaas-node12       vertigobr HTTP-based Node 12 template
...
```

To use these funtions with plain `faas-cli` you can do any of these options:

### 1. OPENFAAS_TEMPLATE_STORE_URL environment variable

```sh
export OPENFAAS_TEMPLATE_STORE_URL="https://raw.githubusercontent.com/vertigobr/openfaas-templates/master/templates.json"
faas-cli template store list
faas-cli template store pull a_template_name
```

### 2. Template pull

```sh
faas-cli template pull https://github.com/vertigobr/openfaas-templates
```


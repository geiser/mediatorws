== Mediator Web Service ==

The *mediator web service* enables the ALD tool and courseware WS to manage (get, update and delete) the information of learner model and domain model.

| Method | URL                | Description                                               |
|:------:|:-------------------|:----------------------------------------------------------|
| GET    | /repositories      | Returns a list of register repositories.                  |
| POST   | /repositories      | Registers a new repository and creates his mapping.       |
| GET    | /repositories/{id} | Returns the mapping of a repository with identifier {id}. |
| POST   | /repositories/{id} | Updates the mapping of a repository with identifier {id}. |
| DELETE | /repositories/{id} | Unregisters a repository with identifier {id}.            |
| GET    | /query             | Makes a query on register repositories.                   |
| POST   | /query             | Updates the information of register repositories.         |

Table shows the REST API provided by our current version of mediator. The most important interface in this API is */query*, where:

-   The parameter *function* with values *BuildElement*, *GetElement*, *GetType*, *GetPropertyValue* and *GetRelated* indicates the query function.

-   The parameters *type[i]*, *property[i].name*, *property[i].value*, *relation[i].name*, and *relation[i].value* are used in the functions *BuildElement* and *GetElement* to define the classifications of elements, the name of i-th property, the value of i-th property, the name of i-th relation, and the identifier of an element relates with the i-th relation with name *relation[i].name*. For example, to obtain exercises with high difficulty that are part of a list of exercises with identifier *e1*, we use the requisition */query*?*function=GetElement*&*type[1]=Auxiliar*&*property[1].name=hasDifficult*&*property[1].value=high*&*relation[1].name=isPartOf*&*relation[1].value=e1*. The parameter *id* in the function *BuildElement* is used to define the identifier of the element to be updated.

-   The parameter *id* and *name* are used in the functions *GetType*, *GetPropertyValue* and *GetRelated* to obtain the list of classification, the values of property with name *name* and the related elements with relation *name*.


---
pageTitle: Type
keywords: grakn, type, api, methods
longTailKeywords: grakn type, type methods, grakn type methods, grakn entity type methods, grakn attribute type methods, grakn relation type methods, grakn role methods
Summary: Methods available on Type objects.
toc: true
---

## Type Methods
`Type` has all the [`Concept` methods](/docs/concept-api/concept) plus what follows.

<div class="tabs light" data-no-parse>

[tab:Java]
{% include api/generic.html data=site.data.concept_api.type language="java" class_prefix="concept-api-java" %}
[tab:end]

[tab:Javascript]
{% include api/generic.html data=site.data.concept_api.type language="javascript" class_prefix="concept-api-nodejs" %}
[tab:end]

[tab:Python]
{% include api/generic.html data=site.data.concept_api.type language="python" class_prefix="concept-api-python" %}
[tab:end]

</div>

## EntityType Methods
`EntityType` has all the [`Type` methods](#type-methods) plus what follows.

<div class="tabs light" data-no-parse>

[tab:Java]
{% include api/generic.html data=site.data.concept_api.entity_type language="java" class_prefix="concept-api-java" %}
[tab:end]

[tab:Javascript]
{% include api/generic.html data=site.data.concept_api.entity_type language="javascript" class_prefix="concept-api-nodejs" %}
[tab:end]

[tab:Python]
{% include api/generic.html data=site.data.concept_api.entity_type language="python" class_prefix="concept-api-python" %}
[tab:end]

</div>

## AttributeType Methods
`AttributeType` has all the [`Type` methods](#type-methods) plus what follows.

<div class="tabs light" data-no-parse>

[tab:Java]
{% include api/generic.html data=site.data.concept_api.attribute_type language="java" class_prefix="concept-api-java" %}
[tab:end]

[tab:Javascript]
{% include api/generic.html data=site.data.concept_api.attribute_type language="javascript" class_prefix="concept-api-nodejs" %}
[tab:end]

[tab:Python]
{% include api/generic.html data=site.data.concept_api.attribute_type language="python" class_prefix="concept-api-python" %}
[tab:end]

</div>

## RelationType Methods
`RelationType` has all the [`Type` methods](#type-methods) plus what follows.

<div class="tabs light" data-no-parse>

[tab:Java]
{% include api/generic.html data=site.data.concept_api.relation_type language="java" class_prefix="concept-api-java" %}
[tab:end]

[tab:Javascript]
{% include api/generic.html data=site.data.concept_api.relation_type language="javascript" class_prefix="concept-api-nodejs" %}
[tab:end]

[tab:Python]
{% include api/generic.html data=site.data.concept_api.relation_type language="python" class_prefix="concept-api-python" %}
[tab:end]

</div>

## Role Methods
`Role` has all the [`Concept` methods](#type-methods) plus what follows.

<div class="tabs light" data-no-parse>

[tab:Java]
<div class="note">
[Important]
At the moment, `Role` inherits an intermediary class which, for the sake of simplicity, has not been documented. Therefore, besides the `Concept` methods, Role inherits the following methods from the `Type` class.
- [label();](?lang=java#concept-api-java-method-retrieve-the-label)
- [type.label(Label.of(label));](?lang=java#concept-api-java-method-rename-the-label)
- [sup();](?lang=java#concept-api-java-method-retrieve-direct-supertype)
- [sup(Type type);](?lang=java#concept-api-java-method-change-direct-supertype)
- [sups();](?lang=java#concept-api-java-method-retrieve-all-supertypes)
- [subs();](?lang=java#concept-api-java-method-retrieve-all-subtypes)
</div>

{% include api/generic.html data=site.data.concept_api.role language="java" class_prefix="concept-api-java" %}
[tab:end]

[tab:Javascript]
<div class="note">
[Important]
At the moment, `Role` inherits an intermediary class which, for the sake of simplicity, has not been documented. Therefore, besides the `Concept` methods, Role inherits the following methods from the `Type` class.
- [label();](?lang=javascript#concept-api-nodejs-method-retrieve-the-label)
- [type.label(Label.of(label));](?lang=javascript#concept-api-nodejs-method-rename-the-label)
- [sup();](?lang=javascript#concept-api-nodejs-method-retrieve-direct-supertype)
- [sup(Type type);](?lang=javascript#concept-api-nodejs-method-change-direct-supertype)
- [sups();](?lang=javascript#concept-api-nodejs-method-retrieve-all-supertypes)
- [subs();](?lang=javascript#concept-api-nodejs-method-retrieve-all-subtypes)
</div>
{% include api/generic.html data=site.data.concept_api.role language="javascript" class_prefix="concept-api-nodejs" %}
[tab:end]

[tab:Python]
<div class="note">
[Important]
At the moment, `Role` inherits an intermediary class which, for the sake of simplicity, has not been documented. Therefore, besides the `Concept` methods, Role inherits the following methods from the `Type` class.
- [label();](?lang=python#concept-api-python-method-retrieve-the-label)
- [type.label(Label.of(label));](?lang=python#concept-api-python-method-rename-the-label)
- [sup();](?lang=python#concept-api-python-method-retrieve-direct-supertype)
- [sup(Type type);](?lang=python#concept-api-python-method-change-direct-supertype)
- [sups();](?lang=python#concept-api-python-method-retrieve-all-supertypes)
- [subs();](?lang=python#concept-api-python-method-retrieve-all-subtypes)
</div>
{% include api/generic.html data=site.data.concept_api.role language="python" class_prefix="concept-api-python" %}
[tab:end]

</div>
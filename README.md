# GRAKN.AI Documentation

This repository contains all content that powers the Grakn Documentation Portal, accessible at [dev.grakn.ai](http://dev.grakn.ai).


## Contribute
- Fork this repository
- Read the [Contribution Guidelines]() carefully
- Issue a pull request

## Contribution Guidelines

### Naming Conventions

**Files and directories**

- Separate words with hyphens (`-`).
- Keep file and directory names compact: in most cases, one or two words that best describe the contained content. Never use more than three words.
- Choosing the same name for different files located in different directories is acceptavble. (eg: `files/social-network/schema.gql` and `files/phone-cals/schema.gql`).
- For naming images, refer to the [Images Guidelines](#images).


**Headlines**

- Headlines should be phrased in a way that when read the user can determine the question that the text is meant to answer. They should describe a use case.
- Use primitive verbs (eg: _Manage Keyspaces_ as opposed to _Managing Keyspaces_).

## Images

- The name of directories placed under `images/`, corresponds to the name of the section as displayed in the sidebar.
- Name of images, while remaining concise, should be to some level descriptive of their content (eg: `compute_path.png` and `compute_path_subgraph.png` as opposed to `compute_0.png` and `compute_1.png`).
- When an image is used across multiple pages, the **same** image file should be referenced, rather than duplicating the image.
- Screenshots of Workbase should be:
  - named after the UI/UX components of the software itself. (eg: `graql-editor_clear-query.png`).
  - taken at screen resolution of 1280 x 720.
  - image sized of 1150 x 670.
  - consistent in their paddings (position of Workbase's layout within the screenshot).

### Style Guide

**Spelling**

Use American.git st

**Headings**
- There are only two levels of headings used across all markdown files:
  - h2 (`##`)
  - h3 (`###`)
- Use Title Case.
- `###` always comes after a `##`.

**Verbs and Pronouns**

- With rare exceptions, the consistent tense used should be the present tense. (ex: _It returns_ as opposed to _It will return_).
- In most cases, the consistent pronoun is `we`. In individual cases, `you` may better convey the message. Never use `I`.

**Lists (Bullet points)**
- When the list item completes the unfinished sentence before the list, end the list item with a period.
- When the concatenation of list items construct one long sentence, end each list items with a comma with the last one ending with a period.
- Have an introductory sentence prior to the list, when possible.

**Footer Notes and Captions**
- When using a phrase, do not end the line with a period (eg: `Computation of shortest path in Workbase`).
- When using a sentence, end the line with a period. `Click on the plus icon to add a new tab.`.

**Formulations**
- Use paragraphs to provide clarity and flow.
- Fist sentence should describe the content of the entire paragraph at a high level.
- Avoid placing critical information in the middle or end of long paragraphs.
- Keep paragraphs short (up to 4 lines), when possible.
- Prefer short sentences to long ones. Only use complex sentence structures (multiple sentences divided by `,`, `;` or `-`), as last resort.
- Keep sentences concise. If a part of a sentence is adding no value to the point that the sentence is meant to deliver, remove it.
- Avoid the assumption that a sentence is self-explanatory. Even if explained in an earlier sentence, repeat yourself to ensure the sentence can be well-understood, without requiring reference to an earlier text.

<!-- **Grakn Terminology**

**Common Terms** -->

### Writing Markdown

**The Basics**
- Use `**` for bolding text.
- Use ` ``` ` for code blocks.
- Use `#` for headings.

**Code Blocks**

- Include the language name right after the opening ` ``` ` (eg: ` ```graql `)
- To automatically link a code keyword to its corresponding documentation, review and maintain the [views/autolink-keywords.js](views/autolink-keywords.js)
- Use ` `` ` within text, to add inline code. Language is not specified for inline code.

**Tabbed Content**
To add tabbed content, use the following structure.

```html
<div class="tabs light">
[tab:Title 1]
...
[tab:end]

[tab:Title 2]
...
[tab:end]

[tab:Title 3]
...
[tab:end]
</div>
```
- Avoid indents inside the `div` tag.
- When the tabbed content is solely a code block, use the `dark` mode (`class`).
- When the tabbed content includes text, use the `light` mode (`class`).
- In the rare occasions, when the tabbed content is solely a Liquid `include` tag, add `data-no-parse` to the `div`.

**Slideshow**

To add slideshows, use the following structure.

```html
<div class="slideshow">

[slide:start]
[header:start]Slide 1[header:end]
[body:start]![Alt text for image 1(path/to/image-1.png)[body:end]
[footer:start]Footer note for slide 1.[footer:end]
[slide:end]

[slide:start]
[header:start]Slide 2[header:end]
[body:start]![Alt text for image 2(path/to/image-2.png)[body:end]
[footer:start]Footer note for slide 2.[footer:end]
[slide:end]

</div>
```

- `header` and `footer` is not required, but encouraged.

**Colored Panels**

To add a colored panel, use the following structure.

```html
 <div class="note">
      [predefined-title]
      body of the note ...
 </div>
```

In order for the above html/markdown to be presented as a colored panel, `predefined-title` must map to an object contained within `coloredPanels` accessible in `views/colored-panels.js`.

**Colored Labels**

To add an inline colored label, use the following structure.

```
[Label Title]
```

In order for the above to be presented as a colored label, the `Label Title` must be included in the `labelsList` accessible in `views/colored-labels.js`.

## Tests

- Code blocks that have no language name, will not be tested.
- Code blocks whose language is not `java`, `javascript` or `python` will not be tested.
- Code blocks that follow the `<!-- test-ignore --> flag, will not be tested.
- Code blocks of `java`, `javascript` or `python` that are not preceded by any test flags, will be tested as snippets. Current snippets are:
    - One or more assignments of Java `GraqlQuery` objects
    - Graql queries
- Code blocks that follow the `<!-- test-standalone file-name.extension --> flag, will be tested as standalones. Standalones are self-contained code blocks, that are expected to compile and run on their own.
- Using the `<!-- test-standalone file-name.extension -->` flag requires modification of one of the following test files:
    - `PhoneCalls.java` or `SocialNetwork.java` under `test/standalone/java/`
    - `phoneCalls.js` or `socialNetwork.js` under `test/standalone/nodejs/`
    - `phone_calls.py` or `social_network.py` under `test/standalone/python/`
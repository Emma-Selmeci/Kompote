## This file is used to note important Jetpack Compose features

## Important

* Always pass modifier to first child!
* Trailing lambda - content/modifier
* Sizes go from leaves to root with possible overrides

## State

```
val someVal = remember { mutableStateOf(initialValue) }
```

## dp and sp

dp is pixel size
sp is font size

## Modifier

```
Modifier
    .padding(10.dp)
    .padding(start = 10.dp, top, end, bottom)
    .fillMaxWidth()
    .heightIn(min = 10.dp)
    .width(10.dp)
```

## Components

### Surface

Like a Swing JPanel

### Row and Column

```
Column(
    verticalArrangement = Arrangement.spacedBy(10.dp)
    contentPadding = PaddingValues(horizontal = 10.dp)
    modifier = modifier
) {
    // content here
}
```

### Box

Components on top of each other!

### Grid

```
LazyHorizontalGrid(
    rows = GridCells.Fixed(2)
    contentPadding = 
    horizontalArrangement = 
    verticalArrangement =
)
```

### Text

```
fontSize = 100.sp
lineHeight = 100.sp
textAlign = TextAlign.someTextAlignment
modifier = Modifier.align(alignment = Alignment.someAlignment)
```

### TextField

Need to use remember to register changes

### Icon

```
imageVector = Icons.Default.Search
contentDescription = ...
```

### Image

You can read more here!
https://developer.android.com/codelabs/basic-android-kotlin-compose-add-images?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-1-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-add-images

## String best practice

https://developer.android.com/codelabs/basic-android-kotlin-compose-add-images?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-1-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-add-images#6
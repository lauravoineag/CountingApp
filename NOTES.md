# The UI
1. Add a label to display current count - [x]
    1. Create a window and add a label - [x]
        1. Create a test for being able to populate the label? [x]

2. Add a button that will increment the count [x]
    1. Assert that the button is on screen [x]
3. Hook up button to increment count
    1. Show that tapping button will emit event [x]

# The business logic (view model etc)

1. Create view model - com.example.laurasapp.MyCountViewModel
    1. Expose the initial count as UI state [x] - com.example.laurasapp.MyCountViewModelTest.initialUiStateWillBeZero
    2. Add a method for incrementing the count [x] - com.example.laurasapp.MyCountViewModel.incrementCount

# The integration (business logic meets UI)
1. Instantiate the view model as part of creating the window? [x] - com.example.laurasapp.MainActivityKt.MyCountWindow(androidx.compose.ui.Modifier)
    1. Demonstrate the integration of the view model and the button and the label [x] - com.example.laurasapp.MyCountWindowTest.willUseViewModel

# Bonus round (For laura)
1. Add reset button
2. Make reset button, reset the count

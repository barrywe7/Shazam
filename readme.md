# Shazam Recruitment Exercise App
The Shazam app was undertaken as part of a recruitment exercise
## Running, Building & Testing Shazam
 - Clone the GitHub repository
 - Import the Shazam project into Android Studio (it was developed using version 2.3.2)
 - Run using a device or emulator at API level 21 or above
 - Unit tests can be run from within Android Studio
 - There are no instrumentation tests at present
## Code Architecture
 - The app is a standard Android project with a simple activity incorporating a Fragment to display the content.
 - The content and position of the recyclerview is saved to the instance state when the fragment is recreated to save unnecessary calls to the network when performing rotations or restoring the activity.
 - Differing content is shown in portrait and landscape mode.
 - An (unthemed) swipe to refresh layout allows new data to be returned from the network.
 - The Fragment contains a RecyclerView to display the chart entries. 
 - When the fragment is created the MainPresenter makes use of an Interactor to instigate a call to the Shazam API on a background thread using RxJava and Retrofit 2. 
 - The data returned from the service is then mapped from the Gson annotated POJOs to a simplified list of parcelable objects for local use by the UI elements.
 - This data is then mapped in the adapter using data binding.
 - Picasso is used to load the images supplied by ShazamAPI. This also uses an LRU cache to store the images. 
 - The Android data binding library is used to bind the views. Dagger 2 is used for Dependency Injection.
 - Selecting one of the items in the list will launch a basic detail activity with a shared transition element animation
### Design patterns used
 - MVVM using Android databinding. For the network retrieval I've used a hybrid MVP approach since most companies use MVP because it is more established but I prefer MVVM. Normally only one of the two would be used.
 - Dependency Injection
 - Builder pattern
### Libraries used
 - RxJava
 - Dagger 2
 - Retrofit 2
 - Picasso
 - OkHttp 3
 - RetroLamda (once Android Studio 2.4 is live this should not be necessary).
 - Android support library (design)
 
## Future Enhancements:
 - Show more details about the track on the detail view
 - Allow track to be played using an intent to one of the services
 - Show an image when the images are empty but there is an image available in one of the content providers
 - Allow ability to share track (via email or other)
 - Improve dividers on grid view (particularly in landscape)
 - Add more comprehensive unit tests
 - Add instrumentation tests
 - Implement caching of network responses
 - Implement better tablet support (master detail view)
 - Implement analytics
 - Add Night/Day themes
 - Introduce pagination of responses (if that's possible - no documentation given)
 - Add translations
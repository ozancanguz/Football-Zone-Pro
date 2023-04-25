# Football-Zone-Pro

I have developed an android game that displays result,rankings and goal kings on Turkish
Super League using modern android language Kotlin and libraries such as Navigation,retrofit,livedata
viewmodel etc.

# Screenshots
![1splash](https://user-images.githubusercontent.com/64928807/234284702-629584d7-37ce-41bd-8bf9-d9f3fac5c0b3.PNG)
![2results](https://user-images.githubusercontent.com/64928807/234284731-a4090592-890b-4da7-b182-82bee49fffb7.PNG)
![3resultsdetails](https://user-images.githubusercontent.com/64928807/234284758-aac19087-3103-4d2c-ab3f-818635ed3ba9.PNG)
![4teamrankings](https://user-images.githubusercontent.com/64928807/234284779-65225fc6-fde5-4b42-ba4a-8cb2e33307fe.PNG)
![5teamrankingsdetails](https://user-images.githubusercontent.com/64928807/234284794-86eca358-8f3d-4a7a-94f2-734f163eac73.PNG)
![6goalkings](https://user-images.githubusercontent.com/64928807/234284816-14e01250-537a-4d51-8342-f5997185a7f3.PNG)


# Demo 
![football zone demo](https://user-images.githubusercontent.com/64928807/233372972-8aee2db1-4f31-4599-8172-57516d3db5fa.gif)


# Architecture

This app implements MVVM architecture. App consist of different fragments and 1 root activity. Activity holds a container layout in order to manage fragments which will be controlled by navigation component. Here is the package structure:

![image](https://user-images.githubusercontent.com/64928807/219080594-d41f9c5c-6621-44dd-be6a-7fb2424b9150.png)

Data

Data package should include response models, data source . It shouldn't know any logic.

UI

UI like a feature. It contains Fragments ,viewmodels,  and feature related classes like a domains, mappers and ui models .. Make sure that all classes here are specific to the this feature. If it is a class that is also used in other features, it should be moved to the common package.

Di

This package may actually be inside the common module. But I prefer to carry outside of core package to be more visible.

**Tools that I used** :

- Navigation Component
- Hilt for dependency injection
- Retrofit 
- Coroutines
- Livedata
- View Binding
- RESTApi
- LottieAnimationView

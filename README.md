# Manage Data with Kotlin

Project name: **Monster**

### Android
Develop in android over MVVM, Kotlin, etc.


1. Modeling an entity [Code here](https://github.com/AnelCC/Monster/pull/1)
0. Reading files from resources and assets [Code here](https://github.com/AnelCC/Monster/pull/1)
0. Parsing and mapping JSON data [Code here](https://github.com/AnelCC/Monster/pull/2)
0. Getting data from a web service with Retrofit [Code here](https://github.com/AnelCC/Monster/pull/2)
0. Creating a RecyclerView to display data [Code here](https://github.com/AnelCC/Monster/pull/3)
0. Displaying images dynamically with Glide [Code here](https://github.com/AnelCC/Monster/pull/3)
0. Publishing and data values with LiveData objects [Code here](https://github.com/AnelCC/Monster/pull/4)
0. Displaying details with data binding [Code here](https://github.com/AnelCC/Monster/pull/4)
0. Reading and writing files [Code here](https://github.com/AnelCC/Monster/pull/5)
0. Managing SQLite databases with Room [Code here](https://github.com/AnelCC/Monster/pull/6)
0. Persisting data in shared preferences [Code here](https://github.com/AnelCC/Monster/pull/7)


### Package Structure
```
com.anelcc.monster      # Root Package
.
├── data                # For API Service, Model classes, and  Repository to handle network API.
│   └── splash          # ViewModel shared
│
├── share               # ViewModels
│   └── splash          # ViewModel shared
│
├── ui                  # Views
│   │── detail          # Fragment
│   │── main            # Fragment
│   └── splash          # Fragment
│
├── utilities
│   │── BindingAdapters    # View model shared
│   │── PreferencesHelper  # View model shared
│   └── FileHelper         # View model shared
│
├── Global.kt              # GlobalVariables
├── MainActivity.kt        # Main Activity
└── SettingsActivity.kt    # Settings Activity
```

### Preview 🎉

<img src="https://raw.githubusercontent.com/AnelCC/Monster/master/image/remoteData.png" width="180" height="300"/><img src="https://raw.githubusercontent.com/AnelCC/Monster/master/image/localDataDB.png" width="180" height="300"/><img src="https://raw.githubusercontent.com/AnelCC/Monster/master/image/HomaPageWithMenuOptions.png" width="180" height="300"/>

<img src="https://raw.githubusercontent.com/AnelCC/Monster/master/image/settingScreen.png" width="180" height="300"/><img src="https://raw.githubusercontent.com/AnelCC/Monster/master/image/SignatureElizabeth.png" width="180" height="300"/><img src="https://raw.githubusercontent.com/AnelCC/Monster/master/image/SettingScreenElizabeth.png" width="180" height="300"/>

<img src="https://raw.githubusercontent.com/AnelCC/Monster/master/image/HomePageWithListView.png" width="180" height="300"/>


### Library References

1. Android Components Navigation [Read here](https://developer.android.com/jetpack/docs/guide)
0. Kotlin [Read here](https://developer.android.com/kotlin/ktx)
0. Retrofit [Read here](https://square.github.io/retrofit/)
0. MVVM [Read here](https://blog.mindorks.com/mvc-mvp-mvvm-architecture-in-android)
0. View Models [Read here](https://developer.android.com/topic/libraries/architecture/viewmodel)
0. DataModel [Read here](https://developer.android.com/topic/libraries/architecture/viewmodel)
0. Glide [Read here](https://bumptech.github.io/glide/doc/download-setup.html)
0. Gson [Read here](https://guides.codepath.com/android/leveraging-the-gson-library)
0. Moshi Kotlin [Read here](https://square.github.io/moshi/1.x/moshi/)
0. Androidx Preference [Read here](https://developer.android.com/jetpack/androidx/releases/preference)
0. Coroutines [Read here](https://developer.android.com/topic/libraries/architecture/coroutines)
0. Support for Room [Read here](https://developer.android.com/training/data-storage/room)


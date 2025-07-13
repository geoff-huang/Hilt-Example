To add Hilt to your project, you can mimic this commit: https://github.com/geoff-huang/Hilt-Example/commit/2820845b6a71d28a3373c6d4d43feadffa39e522


Sample code for providing Prefs DataStore:
```
    @Provides
    @Singleton
    fun providePreferencesDataStore(
        @ApplicationContext context: Context
    ): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create {
            File(context.filesDir, "grid.preferences_pb")
        }
    }
```

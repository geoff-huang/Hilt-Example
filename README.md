To add Hilt to your project, you can mimic this commit: https://github.com/geoff-huang/Hilt-Example/commit/2820845b6a71d28a3373c6d4d43feadffa39e522


Sample module code for providing Prefs DataStore:
```
@Module
@InstallIn(SingletonComponent::class)
object TestModule {

    @Provides
    @Singleton
    fun provideTestRepository(
        prefsDataStore: DataStore<Preferences>
    ): TestRepository {
        return TestRepositoryImpl(prefsDataStore)
    }

    @Provides
    @Singleton
    fun providePreferencesDataStore(
        @ApplicationContext context: Context
    ): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create {
            File(context.filesDir, "test.preferences_pb")
        }
    }
}
```

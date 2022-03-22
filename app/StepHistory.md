---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
step 6.3    Add customized Toolbar
            change theme to NoActionBar
            customized toolbar implemented
---------------------------------------------------------------------------------------------------
step 6.2    convert activity_daily_forecast into fragment
            add fragment_daily_forecast to NavigationGraph
            implement navigation and safeargs to view and NavGraph
            update AppNavigator and MainActivity to navigate to DailyForecast
---------------------------------------------------------------------------------------------------
step 6.1    build NavigationGraph
            edit MainActivity and activity_main.xml
            dependencies checked
            NavigationGraph added and integrated in activity_main.xml
            actions to navigate to fragments implemented and tested
---------------------------------------------------------------------------------------------------
step 6      Navigation
---------------------------------------------------------------------------------------------------
step 5.4    FragmentCurrentForecast erstellen
            FAB zur Eingabe der Postleitzahl einführen
            FragmentContainer auf gesamten ViewContainer ausweiten
            Fragments werden sauber annavigiert
---------------------------------------------------------------------------------------------------
step 5.3    Anzeige der Daten in der RecyclerView
            Interface AppNavigator erstellt und in MainActivity implementiert ->
            ForecastDaten werden bei Aufruf aktualisiert
            In LocationEntryFragment wird Appnavigator aus Mainactivity gecastet.
            -> repository steht zur Verfügung bereit
            Anzeige der Listendaten über den Aufruf des AppNavigators und Übergabe der PLZ
---------------------------------------------------------------------------------------------------
step 5.2    add Fragment programmatically to Activity
            container zum Anzeigen der FRagments erstellt
            Layout für LocationEntryFragment erstellt
            Fragment in MainActivity angezeigt
            Funktionalität für Button eingerichtet
---------------------------------------------------------------------------------------------------
step 5.1  Fragments
        display LocationEntryFragment
        in MainActivity as part
        create CurrentForecastFragment
        create AppNavigation Interface
        add FloatingActionButton to show LocationEntryFragment
---------------------------------------------------------------------------------------------------
step 5  Fragments
        create LocationEntryFragment
        TODO create CurrentForecastFragment
        TODO create AppNavigation Interface
        TODO add FloatingActionButton to show LocationEntryFragment
---------------------------------------------------------------------------------------------------
step 4  Intents, Menus, Dialogs Shared preferences
        ForecastDetailsActivity erstellt
        Intent zum Aufruf der Activity erstellt und Werte mit Extras an Form übertragen
        Settings Menü erstellt und Dialog zum Einstellen von °C und °Fahrenheit
        eingerichtet.
        Shared Preferences erstellt und Dialog zum Ändern der Werte
        Shared Prefs werden bei der Anzeige berücksichtigt
---------------------------------------------------------------------------------------------------
step 3  Recycler View erstellen
        Dataclass DailyForecast erstellt
        Repository (ermittelt vorerst Zufallsdaten) erstellt
        MainActivity mit Observer und RecyclerView
        Adapter für RecyclerView erstellt
        ForecastAdapter mit ClickHandler
        Forecast description customized
---------------------------------------------------------------------------------------------------
step 2  create first app
        first Activity designed and tested, theme changed clickListener implemented
        very simple validation implemented
---------------------------------------------------------------------------------------------------
step 1  creating project
        start with video https://www.youtube.com/watch?v=RS7P9vBRonU
        create master in github
        file dimens ergänzt
---------------------------------------------------------------------------------------------------
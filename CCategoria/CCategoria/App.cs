﻿using System;
using System.Data;

namespace CCategoria
{
    public class App
    {
        private IDbConnection connection;

        public App()
        {
        }


        public static App instance = new App();

		//public static App GetInstance() {
		//    return instance
		//}
		public static App Instance
        {
            get { return instance; }
        }

		//public IDbConnection GetConnection ()
		//{
		//    return conection;
		//}

		//public void Setconnection (IDbConnection connection) {
		//    this.connection = connection;
		//}
		public IDbConnection Connection
        {
            get { return connection; }
            set { connection = value; }
        }

    }
}
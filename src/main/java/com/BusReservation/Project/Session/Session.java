package com.BusReservation.Project.Session;

import jakarta.servlet.http.HttpSession;

public class Session {
        public boolean isLoggedIn(HttpSession session) {
        // Check if the session attribute "loggedInUser" is present
        return session.getAttribute("loggedInUser") != null;
    }
}

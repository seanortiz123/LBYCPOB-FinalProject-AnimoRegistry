const API = "/api";

async function apiRequest(method, path, body) {
    const res = await fetch(API + path, {
        method,
        headers: body ? { "Content-Type": "application/json" } : {},
        body: body ? JSON.stringify(body) : undefined,
    });

    const contentType = res.headers.get("content-type") || "";
    const data = contentType.includes("application/json") ? await res.json() : await res.text();

    if (!res.ok) {
        const message = (data && data.message) ? data.message : "Something went wrong. Please try again.";
        throw new Error(message);
    }
    return data;
}

const api = {
    get: (path) => apiRequest("GET", path),
    post: (path, body) => apiRequest("POST", path, body),
    put: (path, body) => apiRequest("PUT", path, body),
    patch: (path, body) => apiRequest("PATCH", path, body),
    del: (path) => apiRequest("DELETE", path),
};
const SESSION_KEY = "animoregistry.session";

const session = {
    get() {
        try {
            const raw = localStorage.getItem(SESSION_KEY);
            return raw ? JSON.parse(raw) : null;
        } catch {
            return null;
        }
    },
    set(data) {
        localStorage.setItem(SESSION_KEY, JSON.stringify(data));
    },
    clear() {
        localStorage.removeItem(SESSION_KEY);
    },
    isStudent() {
        const s = session.get();
        return !!s && s.role === "student";
    },
    isOfficer() {
        const s = session.get();
        return !!s && s.role === "officer";
    },
};
function renderNav(activePage) {
    const mount = document.getElementById("nav-mount");
    if (!mount) return;

    const s = session.get();

    let rightLinks = "";
    if (!s) {
        rightLinks = `
      <a href="../login.html" class="${activePage === "login" ? "active" : ""}">Log in</a>
      <a href="../register.html" class="${activePage === "register" ? "active" : ""}">Register</a>
    `;
    } else if (s.role === "student") {
        rightLinks = `
      <a href="dashboard.html" class="${activePage === "dashboard" ? "active" : ""}">My dashboard</a>
      <button id="nav-logout">Log out (${escapeHtml(s.name)})</button>
    `;
    } else {
        rightLinks = `
      <a href="officer.html" class="${activePage === "officer" ? "active" : ""}">Officer panel</a>
      <button id="nav-logout">Log out (${escapeHtml(s.name)})</button>
    `;
    }

    mount.innerHTML = `
    <nav class="navbar">
      <div class="wrap">
        <a href="index.html" class="brand"><span class="dot"></span>AnimoRegistry</a>
        <div class="nav-links">
          <a href="index.html" class="${activePage === "home" ? "active" : ""}">Browse orgs</a>
          <a href="../../../about.html" class="${activePage === "about" ? "active" : ""}">About us</a>
          ${rightLinks}
        </div>
      </div>
    </nav>
  `;

    const logoutBtn = document.getElementById("nav-logout");
    if (logoutBtn) {
        logoutBtn.addEventListener("click", () => {
            session.clear();
            window.location.href = "index.html";
        });
    }
}
function requireRole(role) {
    const s = session.get();
    if (!s || s.role !== role) {
        window.location.href = "login.html";
        return null;
    }
    return s;
}
function escapeHtml(str) {
    if (str === null || str === undefined) return "";
    return String(str)
        .replace(/&/g, "&amp;")
        .replace(/</g, "&lt;")
        .replace(/>/g, "&gt;")
        .replace(/"/g, "&quot;");
}

function formatDate(iso) {
    if (!iso) return "—";
    const d = new Date(iso);
    return d.toLocaleString(undefined, {
        month: "short", day: "numeric", year: "numeric", hour: "numeric", minute: "2-digit",
    });
}

function statusLabel(status) {
    const map = {
        PENDING: "Pending",
        INTERVIEW_SCHEDULED: "Interview scheduled",
        ACCEPTED: "Accepted",
        REJECTED: "Rejected",
    };
    return map[status] || status;
}

function showError(el, message) {
    el.textContent = message;
    el.classList.add("show");
}

function hideError(el) {
    el.classList.remove("show");
    el.textContent = "";
}
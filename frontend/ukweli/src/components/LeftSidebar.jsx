import Link from "next/link"

export default function LeftSidebar() {
    const links = [
        { href: "/", label: "Home" },
        { href: "/explore", label: "Explore" },
        { href: "/notifications", label: "Notifications" },
        { href: "/messages", label: "Messages" },
        { href: "/bookmarks", label: "Bookmarks" },
        { href: "/profile", label: "Profile" },
    ]

    return (
        <nav className="w-full lg:w-1/4">
            <div className="bg-white rounded-lg shadow p-6">
                <ul className="space-y-2">
                    {links.map((link) => (
                        <li key={link.href}>
                            <Link
                                href={link.href}
                                className="text-gray-700 hover:text-blue-500 block py-2 px-4 rounded hover:bg-gray-100"
                            >
                                {link.label}
                            </Link>
                        </li>
                    ))}
                </ul>
            </div>
        </nav>
    )
}